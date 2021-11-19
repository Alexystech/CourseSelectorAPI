package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.AsignacionHorario;
import com.slasher.CourseSelectorAPI.service.AsignacionHorarioService;
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
@RequestMapping(path = "/asignacion-horario")
public class AsignacionHorarioRestController {

  private final AsignacionHorarioService asignacionHorarioService;

  @Autowired
  public AsignacionHorarioRestController(AsignacionHorarioService asignacionHorarioService) {
    this.asignacionHorarioService = asignacionHorarioService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<AsignacionHorario> createAsignacionHorario(@RequestBody AsignacionHorario asignacionHorario) {
    return new ResponseEntity<>(asignacionHorarioService
        .createAsignacionHorario(asignacionHorario), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteAsignacionHorarioById(@PathVariable long id) {
    asignacionHorarioService.deleteAsignacionHorario(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<AsignacionHorario> updateAsignacionHorario(@RequestBody AsignacionHorario asignacionHorario) {
    return new ResponseEntity<>(asignacionHorarioService
        .updateAsignacionHorario(asignacionHorario), HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<AsignacionHorario> getAsignacionHorarioById(@PathVariable long id) {
    return new ResponseEntity<>(asignacionHorarioService
        .getAsignacionHorarioById(id), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<AsignacionHorario>> getAllAsignacionesHorario() {
    return new ResponseEntity<>(asignacionHorarioService
        .getAllAsignacionHorarios(), HttpStatus.OK);
  }
}
