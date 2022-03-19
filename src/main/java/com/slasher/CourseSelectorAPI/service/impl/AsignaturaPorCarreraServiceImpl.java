package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;
import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;
import com.slasher.CourseSelectorAPI.entity.SolicitudMateria;
import com.slasher.CourseSelectorAPI.repository.AsigHorarioDefRepository;
import com.slasher.CourseSelectorAPI.repository.AsignaturaPorCarreraRepository;
import com.slasher.CourseSelectorAPI.repository.SolicitudMateriaRespository;
import com.slasher.CourseSelectorAPI.service.AsignaturaPorCarreraService;
import com.slasher.CourseSelectorAPI.service.exception.AsignaturaPorCarreraIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.AsignaturaPorCarreraNotFoundException;
import com.slasher.CourseSelectorAPI.util.MateriasDisponibles;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaPorCarreraServiceImpl implements AsignaturaPorCarreraService {

  private final AsignaturaPorCarreraRepository asigPorCarreraRepository;
  private final AsigHorarioDefRepository asigHorarioDefRepository;
  private final SolicitudMateriaRespository solicitudMateriaRespository;

  @Autowired
  public AsignaturaPorCarreraServiceImpl(AsignaturaPorCarreraRepository asigPorCarreraRepository
          , AsigHorarioDefRepository asigHorarioDefRepository, SolicitudMateriaRespository solicitudMateriaRespository) {
    this.asigPorCarreraRepository = asigPorCarreraRepository;
    this.asigHorarioDefRepository = asigHorarioDefRepository;
    this.solicitudMateriaRespository = solicitudMateriaRespository;
  }

  @Override
  public AsignaturaPorCarrera createAsignaturaPorCarrera(AsignaturaPorCarrera asignaturaPorCarrera) {

    if ( asignaturaPorCarrera == null ) {
      throw AsignaturaPorCarreraIsNullException.of();
    }

    return asigPorCarreraRepository.save(asignaturaPorCarrera);
  }

  @Override
  public void deleteAsignaturaPorCarreraById(long id) {

    if ( id < 1 ) {
      throw AsignaturaPorCarreraNotFoundException.of(id);
    }

    Try.of( () -> getAsignaturaPorCarreraById(id) ).onFailure( (exception) -> {
      throw AsignaturaPorCarreraNotFoundException.of(id);
    });

    asigPorCarreraRepository.deleteById(id);
  }

  @Override
  public AsignaturaPorCarrera updateAsignaturaPorCarrera(AsignaturaPorCarrera asignaturaPorCarrera) {

    if ( asignaturaPorCarrera == null ) {
      throw AsignaturaPorCarreraIsNullException.of();
    }

    return asigPorCarreraRepository.save(asignaturaPorCarrera);
  }

  @Override
  public AsignaturaPorCarrera getAsignaturaPorCarreraById(long id) {
    return asigPorCarreraRepository.findById(id)
        .orElseThrow( () -> AsignaturaPorCarreraNotFoundException.of(id));
  }

  @Override
  public List<AsignaturaPorCarrera> getAllAsignaturasPorCarrera() {
    return ((List<AsignaturaPorCarrera>) asigPorCarreraRepository.findAll());
  }

  @Override
  public List<MateriasDisponibles> getMateriasDisponibles() {
    return asigPorCarreraRepository.findMateriasDisponibles();
  }

  @Override
  public List<AsignaturaPorCarrera> getAsignaturasBySemestre(int semestre, String idJefeCarrera) {
    List<AsignaturaPorCarrera> asignaturasPorCarrera = asigPorCarreraRepository.findAsignaturasBySemestre(semestre, idJefeCarrera);
    List<AsigHorarioDef> asigHorarioDefs = ((List<AsigHorarioDef>) asigHorarioDefRepository.findAll());

    List<AsignaturaPorCarrera> asignaturasNotSelected = asignaturasPorCarrera.stream()
            .filter(asignatura -> !existMateria(asignatura.getIdAsignatura().getIdAsignatura(), asigHorarioDefs))
            .collect(Collectors.toList());

    return asignaturasNotSelected;
  }

  @Override
  public List<AsignaturaPorCarrera> getAsignturaPorCarreaByCarrera(long idCarrera) {
    return asigPorCarreraRepository.findAsignturaPorCarreaByCarrera(idCarrera);
  }

  @Override
  public AsignaturaPorCarrera getAsignaturaPorCarreraByIdAsignatura(long idAsignatura) {
    return asigPorCarreraRepository.findAsignaturaPorCarreraByIdAsignatura(idAsignatura);
  }

  @Override
  public List<AsignaturaPorCarrera> getAsignaturasPorCarreraNotSelected(String idDocente) {
    List<SolicitudMateria> solicitudMaterias = solicitudMateriaRespository
            .findSolicitudMateriaByIdDocente(idDocente);
    List<AsignaturaPorCarrera> asignaturaPorCarreras = getAllAsignaturasPorCarrera();

    List<AsignaturaPorCarrera> asignaturasNotSelected = asignaturaPorCarreras.stream()
            .filter(asignatura -> !existMateria(solicitudMaterias, asignatura.getIdAsigPorCarrera()))
            .collect(Collectors.toList());

    return asignaturasNotSelected;
  }

  private boolean existMateria(long idAsignatura, List<AsigHorarioDef> asigHorarioDefs) {
    boolean exist = asigHorarioDefs.stream()
            .anyMatch(asigHorarioDef -> asigHorarioDef.getIdAsignatura().getIdAsignatura() == idAsignatura);

    return exist;
  }

  private boolean existMateria(List<SolicitudMateria> solicitudMaterias, long idAsigPorCarrera) {
    boolean exist = solicitudMaterias.stream()
            .anyMatch(solicitudMateria -> solicitudMateria
                    .getAsignaturaPorCarrera().getIdAsigPorCarrera() == idAsigPorCarrera);

    return exist;
  }
}
