package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;
import com.slasher.CourseSelectorAPI.util.AsigHorarioDefByDocente;

import java.util.List;

public interface AsigHorarioDefService {
  AsigHorarioDef createAsignacion(AsigHorarioDef asigHorarioDef);
  void deleteAsignacionById(long idAsignacion);
  AsigHorarioDef updateAsignacion(AsigHorarioDef asigHorarioDef);
  AsigHorarioDef getAsignacionById(long idAsignacion);
  List<AsigHorarioDef> getAllAsignaciones();
  List<AsigHorarioDefByDocente> getAllAsignacionesByIdDocente(String idDocente);
  List<AsigHorarioDef> getAsigHorarioDefByIdDocente(String idDocente);
  List<AsigHorarioDef> getAsigHorarioDefByJefeCarrera(String idJefeCarrera);
  AsigHorarioDef getAsigHorarioDefByIdHora(long idHora);
}
