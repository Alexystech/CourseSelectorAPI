package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;
import com.slasher.CourseSelectorAPI.repository.AsignaturaPorCarreraRepository;
import com.slasher.CourseSelectorAPI.service.AsignaturaPorCarreraService;
import com.slasher.CourseSelectorAPI.service.exception.AsignaturaPorCarreraIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.AsignaturaPorCarreraNotFoundException;
import com.slasher.CourseSelectorAPI.util.MateriasDisponibles;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaPorCarreraServiceImpl implements AsignaturaPorCarreraService {

  private AsignaturaPorCarreraRepository asigPorCarreraRepository;

  @Autowired
  public AsignaturaPorCarreraServiceImpl(AsignaturaPorCarreraRepository asigPorCarreraRepository) {
    this.asigPorCarreraRepository = asigPorCarreraRepository;
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
  public List<AsignaturaPorCarrera> getAsignaturasBySemestre(int semestre) {
    return asigPorCarreraRepository.findAsignaturasBySemestre(semestre);
  }
}
