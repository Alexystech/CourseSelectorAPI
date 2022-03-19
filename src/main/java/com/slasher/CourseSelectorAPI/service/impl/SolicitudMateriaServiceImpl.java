package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.SolicitudMateria;
import com.slasher.CourseSelectorAPI.repository.SolicitudMateriaRespository;
import com.slasher.CourseSelectorAPI.service.SolicitudMateriaService;
import com.slasher.CourseSelectorAPI.util.MateriasSolicitadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudMateriaServiceImpl implements SolicitudMateriaService {

  private final SolicitudMateriaRespository solicitudMateriaRespository;

  @Autowired
  public SolicitudMateriaServiceImpl(SolicitudMateriaRespository solicitudMateriaRespository) {
    this.solicitudMateriaRespository = solicitudMateriaRespository;
  }

  @Override
  public SolicitudMateria createSolicitud(SolicitudMateria solicitudMateria) {
    return solicitudMateriaRespository.save(solicitudMateria);
  }

  @Override
  public void deleteSolicitudById(long idSolicitud) {
    solicitudMateriaRespository.deleteById(idSolicitud);
  }

  @Override
  public SolicitudMateria getSolicitudById(long idSolicitud) {
    return solicitudMateriaRespository.findById(idSolicitud).get();
  }

  @Override
  public List<SolicitudMateria> getAllSolicitudes() {
    return ((List<SolicitudMateria>) solicitudMateriaRespository.findAll());
  }

  @Override
  public List<MateriasSolicitadas> getAllMateriasSolicitadas(String idDocente) {
    return solicitudMateriaRespository.findAllMateriasSolicitadas(idDocente);
  }

  @Override
  public List<SolicitudMateria> getSolicitudesByMateria(long asignaturaPorCarrera) {
    return solicitudMateriaRespository.findSolicitudesByMateria(asignaturaPorCarrera);
  }

  @Override
  public List<SolicitudMateria> getSolicitudMateriaByIdDocente(String idDocente) {
    return solicitudMateriaRespository.findSolicitudMateriaByIdDocente(idDocente);
  }
}
