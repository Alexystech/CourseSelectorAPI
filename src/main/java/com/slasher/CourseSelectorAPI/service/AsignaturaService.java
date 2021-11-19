package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.Asignatura;

import java.util.List;

public interface AsignaturaService {
  Asignatura createAsignatura(Asignatura asignatura);
  void deleteAsignaturaById(long id);
  Asignatura updateAsignatura(Asignatura asignatura);
  Asignatura getAsignaturaById(long id);
  List<Asignatura> getAllAsignaturas();
}
