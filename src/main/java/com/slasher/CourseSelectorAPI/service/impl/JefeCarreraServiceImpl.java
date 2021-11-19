package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.JefeCarrera;
import com.slasher.CourseSelectorAPI.repository.JefeCarreraRepository;
import com.slasher.CourseSelectorAPI.service.JefeCarreraService;
import com.slasher.CourseSelectorAPI.service.exception.JefeCarreraIdIsEmptyException;
import com.slasher.CourseSelectorAPI.service.exception.JefeCarreraIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.JefeCarreraNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JefeCarreraServiceImpl implements JefeCarreraService {

  private final JefeCarreraRepository jefeCarreraRepository;
  
  @Autowired
  public JefeCarreraServiceImpl(JefeCarreraRepository jefeCarreraRepository) {
    this.jefeCarreraRepository = jefeCarreraRepository;
  }
  
  @Override
  public JefeCarrera createJefeCarrera(JefeCarrera jefeCarrera) {
    
    if ( jefeCarrera == null ) {
      throw JefeCarreraIsNullException.of();
    }
    
    return jefeCarreraRepository.save(jefeCarrera);
  }

  @Override
  public void deleteJefeCarreraById(String id) {

    if ( id == null ) {
      throw JefeCarreraIsNullException.of();
    }
    
    if ( id.equals("") ) {
      throw JefeCarreraIdIsEmptyException.of();
    }

    Try.of( () -> getJefeCarreraById(id) ).onFailure( (exception) -> {
      throw JefeCarreraNotFoundException.of(id);
    });
    
    jefeCarreraRepository.deleteById(id);
  }

  @Override
  public JefeCarrera updateJefeCarrera(JefeCarrera jefeCarrera) {
    
    if ( jefeCarrera == null ) {
      throw JefeCarreraIsNullException.of();
    }
    
    return jefeCarreraRepository.save(jefeCarrera);
  }

  @Override
  public JefeCarrera getJefeCarreraById(String id) {
    return jefeCarreraRepository.findById(id)
        .orElseThrow( () -> JefeCarreraNotFoundException.of(id) );
  }

  @Override
  public List<JefeCarrera> getAllJefesCarrera() {
    return ((List<JefeCarrera>) jefeCarreraRepository.findAll());
  }
}
