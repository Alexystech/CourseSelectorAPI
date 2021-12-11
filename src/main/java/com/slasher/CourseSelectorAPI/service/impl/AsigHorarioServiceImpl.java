package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;
import com.slasher.CourseSelectorAPI.repository.AsigHorarioDefRepository;
import com.slasher.CourseSelectorAPI.service.AsigHorarioDefService;
import com.slasher.CourseSelectorAPI.util.AsigHorarioDefByDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsigHorarioServiceImpl implements AsigHorarioDefService {

  private final AsigHorarioDefRepository asignacionRepository;

  @Autowired
  public AsigHorarioServiceImpl(AsigHorarioDefRepository asignacionRepository) {
    this.asignacionRepository = asignacionRepository;
  }

  @Override
  public AsigHorarioDef createAsignacion(AsigHorarioDef asigHorarioDef) {
    return asignacionRepository.save(asigHorarioDef);
  }

  @Override
  public void deleteAsignacionById(long idAsignacion) {
    asignacionRepository.deleteById(idAsignacion);
  }

  @Override
  public AsigHorarioDef updateAsignacion(AsigHorarioDef asigHorarioDef) {
    return asignacionRepository.save(asigHorarioDef);
  }

  @Override
  public AsigHorarioDef getAsignacionById(long idAsignacion) {
    return asignacionRepository.findById(idAsignacion).get();
  }

  @Override
  public List<AsigHorarioDef> getAllAsignaciones() {
    return ((List<AsigHorarioDef>) asignacionRepository.findAll());
  }

  @Override
  public List<AsigHorarioDefByDocente> getAllAsignacionesByIdDocente(String idDocente) {
    return asignacionRepository.findAsigHorariosByIdDocente(idDocente);
  }

  @Override
  public List<AsigHorarioDef> getAsigHorarioDefByIdDocente(String idDocente) {
    return asignacionRepository.findAsigHorarioDefByIdDocente(idDocente);
  }
}
