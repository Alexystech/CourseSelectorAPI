package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Asignatura;
import com.slasher.CourseSelectorAPI.service.AsignaturaService;
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
@RequestMapping(path = "/asignatura")
public class AsignaturaRestController {

  private final AsignaturaService asignaturaService;

  @Autowired
  public AsignaturaRestController(AsignaturaService asignaturaService) {
    this.asignaturaService = asignaturaService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura asignatura) {
    return new ResponseEntity<>(asignaturaService
        .createAsignatura(asignatura), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteAsignaturaById(@PathVariable long id) {
    asignaturaService.deleteAsignaturaById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PostMapping(path = "/update")
  public ResponseEntity<Asignatura> updateAsignatura(@RequestBody Asignatura asignatura) {
    return new ResponseEntity<>(asignaturaService
        .updateAsignatura(asignatura), HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable long id) {
    return new ResponseEntity<>(asignaturaService
        .getAsignaturaById(id), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Asignatura>> getAllAsignaturas() {
    return new ResponseEntity<>(asignaturaService
        .getAllAsignaturas(), HttpStatus.OK);
  }

}
