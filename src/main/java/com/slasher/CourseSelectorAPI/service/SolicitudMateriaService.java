package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.SolicitudMateria;
import com.slasher.CourseSelectorAPI.util.MateriasSolicitadas;

import java.util.List;

public interface SolicitudMateriaService {
  SolicitudMateria createSolicitud(SolicitudMateria solicitudMateria);
  void deleteSolicitudById(long idSolicitud);
  SolicitudMateria getSolicitudById(long idSolicitud);
  List<SolicitudMateria> getAllSolicitudes();
  List<MateriasSolicitadas> getAllMateriasSolicitadas(String idAsignaturaPorCarrera);
  List<SolicitudMateria> getSolicitudesByMateria(long asignaturaPorCarrera);
}
