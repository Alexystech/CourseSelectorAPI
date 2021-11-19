package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.Carrera;
import com.slasher.CourseSelectorAPI.repository.CarreraRepository;
import com.slasher.CourseSelectorAPI.service.CarreraService;
import com.slasher.CourseSelectorAPI.service.exception.CarreraIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.CarreraNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService {

  private final CarreraRepository carreraRepository;

  @Autowired
  public CarreraServiceImpl(CarreraRepository carreraRepository) {
    this.carreraRepository = carreraRepository;
  }

  @Override
  public Carrera createCarrera(Carrera carrera) {

    if ( carrera == null ) {
      throw CarreraIsNullException.of();
    }

    return carreraRepository.save(carrera);
  }

  @Override
  public void deleteCarreraById(long id) {

    if ( id < 1 ) {
      throw CarreraIsNullException.of();
    }

    Try.of( () -> getCarreraById(id) ).onFailure( (exception) -> {
      throw CarreraNotFoundException.of(id);
    });

    carreraRepository.deleteById(id);
  }

  @Override
  public Carrera updateCarrera(Carrera carrera) {

    if ( carrera == null ) {
      throw CarreraIsNullException.of();
    }

    return carreraRepository.save(carrera);
  }

  @Override
  public Carrera getCarreraById(long id) {
    return carreraRepository.findById(id)
        .orElseThrow( () -> CarreraNotFoundException.of(id) );
  }

  @Override
  public List<Carrera> getAllCarreras() {
    return ((List<Carrera>) carreraRepository.findAll());
  }
}
