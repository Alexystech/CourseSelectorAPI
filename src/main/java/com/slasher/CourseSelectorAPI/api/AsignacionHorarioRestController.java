package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.AsignacionHorario;
import com.slasher.CourseSelectorAPI.service.AsignacionHorarioService;
import com.slasher.CourseSelectorAPI.util.Horario;
import com.slasher.CourseSelectorAPI.util.TopDocentesMayorDisponibilidad;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

/**
 * Rest controller que nos da una capa en la cual podemos
 * únicamente ejecutar y tratar el happy case del consumo de
 * los diferentes EndPoints gracias al desacoplamiento de código
 * en el nivel de servicio.
 */
@RestController
@RequestMapping(path = "/asignacion-horario")
public class AsignacionHorarioRestController {

  private final AsignacionHorarioService asignacionHorarioService;

  @Autowired
  public AsignacionHorarioRestController(AsignacionHorarioService asignacionHorarioService) {
    this.asignacionHorarioService = asignacionHorarioService;
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 201, message = "created")
  })
  @PostMapping(path = "/create")
  public ResponseEntity<AsignacionHorario> createAsignacionHorario(@RequestBody AsignacionHorario asignacionHorario) {
    return new ResponseEntity<>(asignacionHorarioService
        .createAsignacionHorario(asignacionHorario), HttpStatus.CREATED);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteAsignacionHorarioById(@PathVariable long id) {
    asignacionHorarioService.deleteAsignacionHorario(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 202, message = "accepted")
  })
  @PutMapping(path = "/update")
  public ResponseEntity<AsignacionHorario> updateAsignacionHorario(@RequestBody AsignacionHorario asignacionHorario) {
    return new ResponseEntity<>(asignacionHorarioService
        .updateAsignacionHorario(asignacionHorario), HttpStatus.ACCEPTED);
  }

  @ApiResponses({
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @GetMapping(path = "/get/{id}")
  public ResponseEntity<AsignacionHorario> getAsignacionHorarioById(@PathVariable long id) {
    return new ResponseEntity<>(asignacionHorarioService
        .getAsignacionHorarioById(id), HttpStatus.OK);
  }

  @ApiResponse(code = 200, message = "ok")
  @GetMapping(path = "/get/all")
  public ResponseEntity<List<AsignacionHorario>> getAllAsignacionesHorario() {
    return new ResponseEntity<>(asignacionHorarioService
        .getAllAsignacionHorarios(), HttpStatus.OK);
  }

  @GetMapping(path = "/exist/any/asignacion/horario/by/docente/{idDocente}")
  public ResponseEntity<Boolean> existAnyAsigHorarioByDocenteId(@PathVariable String idDocente) {
    return new ResponseEntity<>(asignacionHorarioService.existAnyAsigHorarioByDocenteId(idDocente),
        HttpStatus.OK);
  }

  @GetMapping(path = "/get/all/asignacion/by/docente/{idDocente}")
  public ResponseEntity<List<Horario>> findAllAignacionesByIdDocente(@PathVariable String idDocente) {
    return new ResponseEntity<>(asignacionHorarioService.findAllAsignacionesByIdDocente(idDocente)
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/top/docentes")
  public ResponseEntity<List<TopDocentesMayorDisponibilidad>> getTopDocentesMayorDisponibilidad() {
    return new ResponseEntity<>(asignacionHorarioService.getTopDocentesMayorDisponibilidad()
        , HttpStatus.OK);
  }

}
