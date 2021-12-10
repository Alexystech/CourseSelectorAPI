package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.JefeCarrera;

import java.util.List;

public interface JefeCarreraService {
  JefeCarrera createJefeCarrera(JefeCarrera jefeCarrera);
  void deleteJefeCarreraById(String id);
  JefeCarrera updateJefeCarrera(JefeCarrera jefeCarrera);
  JefeCarrera getJefeCarreraById(String id);
  List<JefeCarrera> getAllJefesCarrera();
  Boolean login(JefeCarrera jefeCarrera);
  List<JefeCarrera> getJefesCarreraFilteredByIdJefeCarreraInCarreras();
}
