package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.Docente;
import com.slasher.CourseSelectorAPI.repository.DocenteRepository;
import com.slasher.CourseSelectorAPI.service.DocenteService;
import com.slasher.CourseSelectorAPI.service.exception.DocenteIdIsEmptyException;
import com.slasher.CourseSelectorAPI.service.exception.DocenteIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.DocenteNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

  private DocenteRepository docenteRepository;

  @Autowired
  public DocenteServiceImpl(DocenteRepository docenteRepository) {
    this.docenteRepository = docenteRepository;
  }

  @Override
  public Docente createDocente(Docente docente) {

    if ( docente == null ) {
      throw DocenteIsNullException.of();
    }

    return docenteRepository.save(docente);
  }

  @Override
  public void deleteDocenteById(String id) {

    if ( id == null ) {
      throw DocenteIsNullException.of();
    }

    if ( id.equals("") ) {
      throw DocenteIdIsEmptyException.of();
    }

    Try.of( () -> getDocenteById(id) ).onFailure( (exception) -> {
      throw DocenteNotFoundException.of(id);
    });

    docenteRepository.deleteById(id);
  }

  @Override
  public Docente updateDocente(Docente docente) {

    if ( docente == null ) {
      throw DocenteIsNullException.of();
    }

    return docenteRepository.save(docente);
  }

  @Override
  public Docente getDocenteById(String id) {
    return docenteRepository.findById(id)
        .orElseThrow( () -> DocenteNotFoundException.of(id) );
  }

  @Override
  public List<Docente> getAllDocentes() {
    return ((List<Docente>) docenteRepository.findAll());
  }
}
