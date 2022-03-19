package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;
import com.slasher.CourseSelectorAPI.entity.Hora;
import com.slasher.CourseSelectorAPI.repository.AsigHorarioDefRepository;
import com.slasher.CourseSelectorAPI.repository.HoraRepository;
import com.slasher.CourseSelectorAPI.service.AsigHorarioDefService;
import com.slasher.CourseSelectorAPI.service.HoraService;
import com.slasher.CourseSelectorAPI.service.exception.HoraIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.HoraNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoraServiceImpl implements HoraService {

  private final HoraRepository horaRepository;
  private final AsigHorarioDefService asigHorarioDefService;

  @Autowired
  public HoraServiceImpl(HoraRepository horaRepository, AsigHorarioDefService asigHorarioDefService) {
    this.horaRepository = horaRepository;
    this.asigHorarioDefService = asigHorarioDefService;
  }

  @Override
  public Hora createHora(Hora hora) {
    
    if ( hora == null ) {
      throw HoraIsNullException.of();
    }
    
    return horaRepository.save(hora);
  }

  @Override
  public void deleteHoraById(long id) {

    if ( id < 1 ) {
      throw HoraIsNullException.of();
    }

    Try.of( () -> getHoraById(id) ).onFailure( (exception) -> {
      throw HoraNotFoundException.of(id);
    });
    
    horaRepository.deleteById(id);
  }

  @Override
  public Hora updateHora(Hora hora) {
    
    if ( hora == null ) {
      throw HoraIsNullException.of();
    }
    
    return horaRepository.save(hora);
  }

  @Override
  public Hora getHoraById(long id) {
    return horaRepository.findById(id)
        .orElseThrow( () -> HoraNotFoundException.of(id) );
  }

  @Override
  public List<Hora> getAllHoras() {
    return ((List<Hora>) horaRepository.findAll());
  }

  @Override
  public List<Hora> getHorasNotSelected(String idJefeCarrera) {
    List<Hora> horas = getAllHoras();
    List<AsigHorarioDef> asigHorarioDefs = asigHorarioDefService
            .getAsigHorarioDefByJefeCarrera(idJefeCarrera);

    List<Hora> horasNotSelected = horas.stream()
            .filter(hora -> !existHora(hora.getIdHora(), asigHorarioDefs))
            .collect(Collectors.toList());

    return horasNotSelected;
  }

  private boolean existHora(long idHora, List<AsigHorarioDef> asigHorarioDefs) {

    boolean exist = asigHorarioDefs.stream().anyMatch(asigHorarioDef ->
            asigHorarioDef.getIdAsignatura().getIdAsignatura() == idHora
    );

    if (exist) {
      return true;
    } else {
      return false;
    }
  }
}
