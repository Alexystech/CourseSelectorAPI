package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.AsignacionHorario;
import com.slasher.CourseSelectorAPI.util.Horario;
import com.slasher.CourseSelectorAPI.util.TopDocentesMayorDisponibilidad;

import java.util.List;

public interface AsignacionHorarioService {
  AsignacionHorario createAsignacionHorario(AsignacionHorario asignacionHorario);
  void deleteAsignacionHorario(long idAsignacionHorario);
  AsignacionHorario updateAsignacionHorario(AsignacionHorario asignacionHorario);
  AsignacionHorario getAsignacionHorarioById(long idAsignacionHorario);
  List<AsignacionHorario> getAllAsignacionHorarios();
  Boolean existAnyAsigHorarioByDocenteId(String idDocente);
  List<Horario> findAllAsignacionesByIdDocente(String idDocente);
  List<TopDocentesMayorDisponibilidad> getTopDocentesMayorDisponibilidad();
}
