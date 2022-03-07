package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.Carrera;
import com.slasher.CourseSelectorAPI.entity.JefeCarrera;
import com.slasher.CourseSelectorAPI.repository.CarreraRepository;
import com.slasher.CourseSelectorAPI.repository.JefeCarreraRepository;
import com.slasher.CourseSelectorAPI.service.JefeCarreraService;
import com.slasher.CourseSelectorAPI.service.exception.JefeCarreraIdIsEmptyException;
import com.slasher.CourseSelectorAPI.service.exception.JefeCarreraIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.JefeCarreraNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class JefeCarreraServiceImpl implements JefeCarreraService {

  private final JefeCarreraRepository jefeCarreraRepository;
  private final CarreraRepository carreraRepository;
  
  @Autowired
  public JefeCarreraServiceImpl(JefeCarreraRepository jefeCarreraRepository, CarreraRepository carreraRepository) {
    this.jefeCarreraRepository = jefeCarreraRepository;
    this.carreraRepository = carreraRepository;
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

  @Override
  public Boolean login(JefeCarrera jefeCarrera) {

    boolean authResult = getAllJefesCarrera().stream().anyMatch( cco ->
        cco.getIdJefeCarrera().equals(jefeCarrera.getIdJefeCarrera()) &&
        cco.getPassword().equals(jefeCarrera.getPassword()));

    if (authResult) {
      return true;
    }

    return false;
  }

  @Override
  public List<JefeCarrera> getJefesCarreraFilteredByIdJefeCarreraInCarreras() {
    List<JefeCarrera> jefeCarreras = getAllJefesCarrera();
    List<Carrera> carreras = ((List<Carrera>) carreraRepository.findAll());
    List<JefeCarrera> filteredJefeCarrera = new LinkedList<>();

    for (int x = 0; x < jefeCarreras.size(); x++) {

      boolean exist = false;
      String idJefeCarrera = jefeCarreras.get(x).getIdJefeCarrera();

      for (int j = 0; j < carreras.size(); j++) {

        String fkIdJefeCarrera = carreras.get(j).getJefeCarrera().getIdJefeCarrera();

        if (Objects.equals(idJefeCarrera, fkIdJefeCarrera)) {
          exist = true;
          break;
        }
      }

      if ( !exist ) {
        filteredJefeCarrera.add(jefeCarreras.get(x));
      }
    }

    filteredJefeCarrera.forEach(x -> System.out.println(x.getIdJefeCarrera()));
    return filteredJefeCarrera;
  }
}
