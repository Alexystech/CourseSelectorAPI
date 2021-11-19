package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.Asignatura;
import com.slasher.CourseSelectorAPI.repository.AsignaturaRepository;
import com.slasher.CourseSelectorAPI.service.AsignaturaService;
import com.slasher.CourseSelectorAPI.service.exception.AsignaturaIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.AsignaturaNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

  private final AsignaturaRepository asignaturaRepository;
  
  @Autowired
  public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
    this.asignaturaRepository = asignaturaRepository;
  }
  
  @Override
  public Asignatura createAsignatura(Asignatura asignatura) {
    
    if ( asignatura == null ) {
      throw AsignaturaIsNullException.of();
    }
    
    return asignaturaRepository.save(asignatura);
  }

  @Override
  public void deleteAsignaturaById(long id) {
    
    if ( id < 1 ) {
      throw AsignaturaIsNullException.of();
    }

    Try.of( () -> getAsignaturaById(id) ).onFailure( (exception) -> {
      throw AsignaturaNotFoundException.of(id);
    });
    
    asignaturaRepository.deleteById(id);
  }

  @Override
  public Asignatura updateAsignatura(Asignatura asignatura) {
    
    if ( asignatura == null ) {
      throw AsignaturaIsNullException.of();
    }
    
    return asignaturaRepository.save(asignatura);
  }

  @Override
  public Asignatura getAsignaturaById(long id) {
    return asignaturaRepository.findById(id)
        .orElseThrow( () -> AsignaturaNotFoundException.of(id) );
  }

  @Override
  public List<Asignatura> getAllAsignaturas() {
    return ((List<Asignatura>) asignaturaRepository.findAll());
  }
}
