package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;
import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;
import com.slasher.CourseSelectorAPI.entity.Carrera;
import com.slasher.CourseSelectorAPI.repository.AsigHorarioDefRepository;
import com.slasher.CourseSelectorAPI.repository.AsignaturaPorCarreraRepository;
import com.slasher.CourseSelectorAPI.repository.CarreraRepository;
import com.slasher.CourseSelectorAPI.service.AsigHorarioDefService;
import com.slasher.CourseSelectorAPI.util.AsigHorarioDefByDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class AsigHorarioServiceImpl implements AsigHorarioDefService {

  private final AsignaturaPorCarreraRepository asignaturaPorCarreraRepository;
  private final AsigHorarioDefRepository asignacionRepository;
  private final CarreraRepository carreraRepository;

  @Autowired
  public AsigHorarioServiceImpl(AsignaturaPorCarreraRepository asignaturaPorCarreraRepository,
                                AsigHorarioDefRepository asignacionRepository,
                                CarreraRepository carreraRepository) {
    this.asignaturaPorCarreraRepository = asignaturaPorCarreraRepository;
    this.asignacionRepository = asignacionRepository;
    this.carreraRepository = carreraRepository;
  }

  @Override
  public AsigHorarioDef createAsignacion(AsigHorarioDef asigHorarioDef) {
    return asignacionRepository.save(asigHorarioDef);
  }

  @Override
  public void deleteAsignacionById(long idAsignacion) {
    asignacionRepository.deleteById(idAsignacion);
  }

  @Override
  public AsigHorarioDef updateAsignacion(AsigHorarioDef asigHorarioDef) {
    return asignacionRepository.save(asigHorarioDef);
  }

  @Override
  public AsigHorarioDef getAsignacionById(long idAsignacion) {
    return asignacionRepository.findById(idAsignacion).get();
  }

  @Override
  public List<AsigHorarioDef> getAllAsignaciones() {
    return ((List<AsigHorarioDef>) asignacionRepository.findAll());
  }

  @Override
  public List<AsigHorarioDefByDocente> getAllAsignacionesByIdDocente(String idDocente) {
    return asignacionRepository.findAsigHorariosByIdDocente(idDocente);
  }

  @Override
  public List<AsigHorarioDef> getAsigHorarioDefByIdDocente(String idDocente) {
    return asignacionRepository.findAsigHorarioDefByIdDocente(idDocente);
  }

  @Override
  public List<AsigHorarioDef> getAsigHorarioDefByJefeCarrera(String idJefeCarrera) {
    Carrera carrera = carreraRepository.findCarrerasByIdJefeCarrera(idJefeCarrera);

    System.out.println(carrera.getNombreCarrera());

    List<AsignaturaPorCarrera> asignaturasPorCarrera = asignaturaPorCarreraRepository
            .findAsignturaPorCarreaByCarrera(carrera.getIdCarrera());
    List<AsigHorarioDef> asigHorarioDefs = ((List<AsigHorarioDef>) asignacionRepository.findAll());

    List<AsigHorarioDef> asigHorarioDefByJC = new LinkedList<>();

    for (AsigHorarioDef asigHorarioDef : asigHorarioDefs) {

      for (AsignaturaPorCarrera asignaturaPorCarrera : asignaturasPorCarrera) {

        if (Objects.equals(asigHorarioDef.getIdAsignatura().getIdAsignatura(),
                asignaturaPorCarrera.getIdAsignatura().getIdAsignatura())) {
          asigHorarioDefByJC.add(asigHorarioDef);
          break;
        }

      }

    }

    return asigHorarioDefByJC;
  }

  @Override
  public AsigHorarioDef getAsigHorarioDefByIdHora(long idHora) {
    return asignacionRepository.findAsigHorarioDefByIdHoraIdHora(idHora);
  }
}
