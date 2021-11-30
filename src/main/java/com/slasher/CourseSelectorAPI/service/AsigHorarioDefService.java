package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;

import java.util.List;

public interface AsigHorarioDefService {
  AsigHorarioDef createAsignacion(AsigHorarioDef asigHorarioDef);
  void deleteAsignacionById(long idAsignacion);
  AsigHorarioDef updateAsignacion(AsigHorarioDef asigHorarioDef);
  AsigHorarioDef getAsignacionById(long idAsignacion);
  List<AsigHorarioDef> getAllAsignaciones();
}
