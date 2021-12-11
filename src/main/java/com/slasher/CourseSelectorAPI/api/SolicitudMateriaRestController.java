package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.SolicitudMateria;
import com.slasher.CourseSelectorAPI.service.SolicitudMateriaService;
import com.slasher.CourseSelectorAPI.util.MateriasSolicitadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/solicitud/materia")
public class SolicitudMateriaRestController {

  private final SolicitudMateriaService solicitudMateriaService;

  @Autowired
  public SolicitudMateriaRestController(SolicitudMateriaService solicitudMateriaService) {
    this.solicitudMateriaService = solicitudMateriaService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<SolicitudMateria> createSolicitud(@RequestBody SolicitudMateria solicitudMateria) {
    return new ResponseEntity<>(solicitudMateriaService.createSolicitud(solicitudMateria)
        , HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{idSolicitud}")
  public ResponseEntity<Boolean> deleteSolicitudById(@PathVariable long idSolicitud) {
    solicitudMateriaService.deleteSolicitudById(idSolicitud);
    return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{idSolicitud}")
  public ResponseEntity<SolicitudMateria> getSolicitudById(@PathVariable long idSolicitud) {
    return new ResponseEntity<>(solicitudMateriaService.getSolicitudById(idSolicitud)
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<SolicitudMateria>> getAllSolicitudes() {
    return new ResponseEntity<>(solicitudMateriaService.getAllSolicitudes()
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/materias/solicitadas/by/{idDocente}")
  public ResponseEntity<List<MateriasSolicitadas>> getAllMateriasSolicitadas(@PathVariable String idDocente) {
    return new ResponseEntity<>(solicitudMateriaService.getAllMateriasSolicitadas(idDocente)
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/solicitudes/by/{asignaturaPorCarrera}")
  public ResponseEntity<List<SolicitudMateria>> getSolicitudesByMateria(@PathVariable long asignaturaPorCarrera) {
    return new ResponseEntity<>(solicitudMateriaService.getSolicitudesByMateria(asignaturaPorCarrera)
        , HttpStatus.OK);
  }

}
