package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;

import java.util.List;

public interface AsignaturaPorCarreraService {
  AsignaturaPorCarrera createAsignaturaPorCarrera(AsignaturaPorCarrera asignaturaPorCarrera);
  void deleteAsignaturaPorCarreraById(long id);
  AsignaturaPorCarrera updateAsignaturaPorCarrera(AsignaturaPorCarrera asignaturaPorCarrera);
  AsignaturaPorCarrera getAsignaturaPorCarreraById(long id);
  List<AsignaturaPorCarrera> getAllAsignaturasPorCarrera();
}
