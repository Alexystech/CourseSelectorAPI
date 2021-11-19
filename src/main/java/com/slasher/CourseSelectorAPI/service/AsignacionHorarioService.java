package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.AsignacionHorario;

import java.util.List;

public interface AsignacionHorarioService {
  AsignacionHorario createAsignacionHorario(AsignacionHorario asignacionHorario);
  void deleteAsignacionHorario(long idAsignacionHorario);
  AsignacionHorario updateAsignacionHorario(AsignacionHorario asignacionHorario);
  AsignacionHorario getAsignacionHorarioById(long idAsignacionHorario);
  List<AsignacionHorario> getAllAsignacionHorarios();
}
