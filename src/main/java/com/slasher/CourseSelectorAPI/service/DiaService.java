package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.Dia;

import java.util.List;

public interface DiaService {
  Dia createDia(Dia dia);
  void deleteDiaById(long idDia);
  Dia updateDia(Dia dia);
  Dia getDiaById(long idDia);
  List<Dia> getAllDias();
}
