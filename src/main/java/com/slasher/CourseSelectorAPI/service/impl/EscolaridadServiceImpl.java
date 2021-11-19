package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.Escolaridad;
import com.slasher.CourseSelectorAPI.repository.EscolaridadRepository;
import com.slasher.CourseSelectorAPI.service.EscolaridadService;
import com.slasher.CourseSelectorAPI.service.exception.EscolaridadIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.EscolaridadNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaridadServiceImpl implements EscolaridadService {

  private final EscolaridadRepository escolaridadRepository;
  
  @Autowired
  public EscolaridadServiceImpl(EscolaridadRepository escolaridadRepository) {
    this.escolaridadRepository = escolaridadRepository;
  }
  
  @Override
  public Escolaridad createEscolaridad(Escolaridad escolaridad) {
    
    if ( escolaridad == null ) {
      throw EscolaridadIsNullException.of();
    }
    
    return escolaridadRepository.save(escolaridad);
  }

  @Override
  public void deleteEscolaridadById(long id) {
    
    if ( id < 1 ) {
      throw EscolaridadIsNullException.of();
    }

    Try.of( () -> getEscolaridadById(id) ).onFailure( (exception) -> {
      throw EscolaridadNotFoundException.of(id);
    });
    
    escolaridadRepository.deleteById(id);
  }

  @Override
  public Escolaridad updateEscolaridad(Escolaridad escolaridad) {
    
    if ( escolaridad == null ) {
      throw EscolaridadIsNullException.of();
    }
    
    return escolaridadRepository.save(escolaridad);
  }

  @Override
  public Escolaridad getEscolaridadById(long id) {
    return escolaridadRepository.findById(id)
        .orElseThrow( () -> EscolaridadNotFoundException.of(id) );
  }

  @Override
  public List<Escolaridad> getAllEscolaridades() {
    return ((List<Escolaridad>) escolaridadRepository.findAll());
  }
}
