package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.Horario;
import com.slasher.CourseSelectorAPI.repository.HorarioRepository;
import com.slasher.CourseSelectorAPI.service.HorarioService;
import com.slasher.CourseSelectorAPI.service.exception.HorarioIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.HorarioNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {

  private final HorarioRepository horarioRepository;

  @Autowired
  public HorarioServiceImpl(HorarioRepository horarioRepository) {
    this.horarioRepository = horarioRepository;
  }

  @Override
  public Horario createHorario(Horario horario) {
    
    if ( horario == null ) {
      throw HorarioIsNullException.of();
    }
    
    return horarioRepository.save(horario);
  }

  @Override
  public void deleteHorarioById(long id) {

    if ( id < 1 ) {
      throw HorarioIsNullException.of();
    }

    Try.of( () -> getHorarioById(id) ).onFailure( (exception) -> {
      throw HorarioNotFoundException.of(id);
    });
    
    horarioRepository.deleteById(id);
  }

  @Override
  public Horario updateHorario(Horario horario) {
    
    if ( horario == null ) {
      throw HorarioIsNullException.of();
    }
    
    return horarioRepository.save(horario);
  }

  @Override
  public Horario getHorarioById(long id) {
    return horarioRepository.findById(id)
        .orElseThrow( () -> HorarioNotFoundException.of(id) );
  }

  @Override
  public List<Horario> getAllHorarios() {
    return ((List<Horario>) horarioRepository.findAll());
  }
}
