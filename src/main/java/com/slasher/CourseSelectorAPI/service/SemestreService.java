package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.Semestre;

import java.util.List;

public interface SemestreService {
  Semestre createSemestre(Semestre semestre);
  void deleteSemestreById(long idSemestre);
  Semestre updateSemestre(Semestre semestre);
  Semestre getSemestreById(long idSemestre);
  List<Semestre> getAllSemestres();
}
