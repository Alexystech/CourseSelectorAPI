package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.Escolaridad;

import java.util.List;

public interface EscolaridadService {
  Escolaridad createEscolaridad(Escolaridad escolaridad);
  void deleteEscolaridadById(long id);
  Escolaridad updateEscolaridad(Escolaridad escolaridad);
  Escolaridad getEscolaridadById(long id);
  List<Escolaridad> getAllEscolaridades();
  List<Escolaridad> getEscolaridadesByIdDocente(String idDocente);
}
