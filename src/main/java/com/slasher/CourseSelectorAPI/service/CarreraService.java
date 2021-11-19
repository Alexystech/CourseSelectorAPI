package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.Carrera;

import java.util.List;

public interface CarreraService {
  Carrera createCarrera(Carrera carrera);
  void deleteCarreraById(long id);
  Carrera updateCarrera(Carrera carrera);
  Carrera getCarreraById(long id);
  List<Carrera> getAllCarreras();
}
