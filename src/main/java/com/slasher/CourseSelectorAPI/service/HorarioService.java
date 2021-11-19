package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.Horario;

import java.util.List;

public interface HorarioService {
  Horario createHorario(Horario horario);
  void deleteHorarioById(long id);
  Horario updateHorario(Horario horario);
  Horario getHorarioById(long id);
  List<Horario> getAllHorarios();
}
