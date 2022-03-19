package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.Hora;

import java.util.List;

public interface HoraService {
  Hora createHora(Hora hora);
  void deleteHoraById(long id);
  Hora updateHora(Hora hora);
  Hora getHoraById(long id);
  List<Hora> getAllHoras();
  List<Hora> getHorasNotSelected(String idJefeCarrera);
}
