package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.AsignacionHorario;
import com.slasher.CourseSelectorAPI.entity.Docente;
import com.slasher.CourseSelectorAPI.repository.AsignacionHorarioRepository;
import com.slasher.CourseSelectorAPI.service.AsignacionHorarioService;
import com.slasher.CourseSelectorAPI.service.exception.AsignacionHorarioIsNullException;
import com.slasher.CourseSelectorAPI.service.exception.AsignacionHorarioNotFoundException;
import com.slasher.CourseSelectorAPI.util.Horario;
import com.slasher.CourseSelectorAPI.util.TopDocentesMayorDisponibilidad;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignacionHorarioServiceImpl implements AsignacionHorarioService {

  private AsignacionHorarioRepository asigHorarioRepository;

  @Autowired
  public AsignacionHorarioServiceImpl(AsignacionHorarioRepository asigHorarioRepository) {
    this.asigHorarioRepository = asigHorarioRepository;
  }

  @Override
  public AsignacionHorario createAsignacionHorario(AsignacionHorario asignacionHorario) {

    if ( asignacionHorario == null ) {
      throw AsignacionHorarioIsNullException.of();
    }

    return asigHorarioRepository.save(asignacionHorario);
  }

  @Override
  public void deleteAsignacionHorario(long id) {

    if ( id < 1 ) {
      throw AsignacionHorarioIsNullException.of();
    }

    Try.of( () -> getAsignacionHorarioById(id) )
        .onFailure( (exception) -> {
          throw AsignacionHorarioNotFoundException.of(id);
        });

    asigHorarioRepository.deleteById(id);
  }

  @Override
  public AsignacionHorario updateAsignacionHorario(AsignacionHorario asignacionHorario) {

    if ( asignacionHorario == null ) {
      throw AsignacionHorarioIsNullException.of();
    }

    return asigHorarioRepository.save(asignacionHorario);
  }

  @Override
  public AsignacionHorario getAsignacionHorarioById(long id) {
    return asigHorarioRepository.findById(id)
        .orElseThrow(() -> AsignacionHorarioNotFoundException.of(id));
  }

  @Override
  public List<AsignacionHorario> getAllAsignacionHorarios() {
    return ((List<AsignacionHorario>) asigHorarioRepository.findAll());
  }

  @Override
  public Boolean existAnyAsigHorarioByDocenteId(String idDocente) {
    return getAllAsignacionHorarios().stream().anyMatch(asignacionHorario ->
        asignacionHorario.getIdDocente().getIdDocente().equals(idDocente));
  }

  @Override
  public List<Horario> findAllAsignacionesByIdDocente(String idDocente) {
    return asigHorarioRepository.findAllAsignacionesByIdDocente(idDocente);
  }

  @Override
  public List<TopDocentesMayorDisponibilidad> getTopDocentesMayorDisponibilidad() {
    List<Docente> docentes = asigHorarioRepository.findAllDocentes();

    List<TopDocentesMayorDisponibilidad> docentesMayorDisponibilidad = docentes.stream()
        .map(docente -> {
          String idDocente = docente.getIdDocente();
          int horas = findAllAsignacionesByIdDocente(docente.getIdDocente()).size() * 2;

          return new TopDocentesMayorDisponibilidad(idDocente, horas);
        }).collect(Collectors.toList());

    return docentesMayorDisponibilidad;
  }

}
