package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.Semestre;
import com.slasher.CourseSelectorAPI.repository.SemestreRepository;
import com.slasher.CourseSelectorAPI.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemestreServiceImpl implements SemestreService {

  private final SemestreRepository semestreRepository;
  
  @Autowired
  public SemestreServiceImpl(SemestreRepository semestreRepository) {
    this.semestreRepository = semestreRepository;
  }
  
  @Override
  public Semestre createSemestre(Semestre semestre) {
    return semestreRepository.save(semestre);
  }

  @Override
  public void deleteSemestreById(long idSemestre) {
    semestreRepository.deleteById(idSemestre);
  }

  @Override
  public Semestre updateSemestre(Semestre semestre) {
    return semestreRepository.save(semestre);
  }

  @Override
  public Semestre getSemestreById(long idSemestre) {
    return semestreRepository.findById(idSemestre).get();
  }

  @Override
  public List<Semestre> getAllSemestres() {
    return ((List<Semestre>) semestreRepository.findAll());
  }
}
