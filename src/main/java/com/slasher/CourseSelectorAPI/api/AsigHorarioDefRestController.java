package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;
import com.slasher.CourseSelectorAPI.service.AsigHorarioDefService;
import com.slasher.CourseSelectorAPI.util.AsigHorarioDefByDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/asignacion")
public class AsigHorarioDefRestController {

  private final AsigHorarioDefService asignacionService;

  @Autowired
  public AsigHorarioDefRestController(AsigHorarioDefService asignacionService) {
    this.asignacionService = asignacionService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<AsigHorarioDef> createAsignacion(@RequestBody AsigHorarioDef asigHorarioDef) {
    return new ResponseEntity<>(asignacionService.createAsignacion(asigHorarioDef)
        , HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{idAsignacion}")
  public ResponseEntity<Boolean> deleteAsignacionById(@PathVariable long idAsignacion) {
    asignacionService.deleteAsignacionById(idAsignacion);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<AsigHorarioDef> updateAsignacion(@RequestBody AsigHorarioDef asigHorarioDef) {
    return new ResponseEntity<>(asignacionService.updateAsignacion(asigHorarioDef)
        , HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{idAsignacion}")
  public ResponseEntity<AsigHorarioDef> getAsignacion(@PathVariable long idAsignacion) {
    return new ResponseEntity<>(asignacionService.getAsignacionById(idAsignacion)
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<AsigHorarioDef>> getAllAsignaciones() {
    return new ResponseEntity<>(asignacionService.getAllAsignaciones()
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/all/asignaciones/by/docente/{idDocente}")
  public ResponseEntity<List<AsigHorarioDefByDocente>> getAllAsignacionesByIdDocente(@PathVariable String idDocente) {
    return new ResponseEntity<>(asignacionService.getAllAsignacionesByIdDocente(idDocente)
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/all/asig/def/by/docente/{idDocente}")
  public ResponseEntity<List<AsigHorarioDef>> getAsigHorarioDefByIdDocente(@PathVariable String idDocente) {
    return new ResponseEntity<>(asignacionService.getAsigHorarioDefByIdDocente(idDocente)
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/asig/def/by/jefe/carrera/{idJefeCarrera}")
  public ResponseEntity<List<AsigHorarioDef>> getAsigHorarioDefByJefeCarrera(@PathVariable String idJefeCarrera) {
    return new ResponseEntity<>(asignacionService.getAsigHorarioDefByJefeCarrera(idJefeCarrera)
            , HttpStatus.OK);
  }

}
