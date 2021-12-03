package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.Docente;

import java.util.List;

public interface DocenteService {
  Docente createDocente(Docente docente);
  void deleteDocenteById(String id);
  Docente updateDocente(Docente docente);
  Docente getDocenteById(String id);
  List<Docente> getAllDocentes();
  Boolean login(Docente docente);
}
