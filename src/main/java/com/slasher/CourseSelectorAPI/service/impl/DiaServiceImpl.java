package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.Dia;
import com.slasher.CourseSelectorAPI.repository.DiaRepository;
import com.slasher.CourseSelectorAPI.service.DiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaServiceImpl implements DiaService {

  private final DiaRepository diaRepository;
  
  @Autowired
  public DiaServiceImpl(DiaRepository diaRepository) {
    this.diaRepository = diaRepository;
  }
  
  @Override
  public Dia createDia(Dia dia) {
    return diaRepository.save(dia);
  }

  @Override
  public void deleteDiaById(long idDia) {
    diaRepository.deleteById(idDia);
  }

  @Override
  public Dia updateDia(Dia dia) {
    return diaRepository.save(dia);
  }

  @Override
  public Dia getDiaById(long idDia) {
    return diaRepository.findById(idDia).get();
  }

  @Override
  public List<Dia> getAllDias() {
    return ((List<Dia>) diaRepository.findAll());
  }
}
