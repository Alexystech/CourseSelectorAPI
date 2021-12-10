package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;
import com.slasher.CourseSelectorAPI.util.MateriasDisponibles;

import java.util.List;

public interface AsignaturaPorCarreraService {
  AsignaturaPorCarrera createAsignaturaPorCarrera(AsignaturaPorCarrera asignaturaPorCarrera);
  void deleteAsignaturaPorCarreraById(long id);
  AsignaturaPorCarrera updateAsignaturaPorCarrera(AsignaturaPorCarrera asignaturaPorCarrera);
  AsignaturaPorCarrera getAsignaturaPorCarreraById(long id);
  List<AsignaturaPorCarrera> getAllAsignaturasPorCarrera();
  List<MateriasDisponibles> getMateriasDisponibles();
}
