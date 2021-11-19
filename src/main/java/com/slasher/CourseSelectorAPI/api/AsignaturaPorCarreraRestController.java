package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;
import com.slasher.CourseSelectorAPI.service.AsignaturaPorCarreraService;
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
@RequestMapping(path = "/asignatura-por-carrera")
public class AsignaturaPorCarreraRestController {

  private final AsignaturaPorCarreraService asigPorCarreraService;

  @Autowired
  public AsignaturaPorCarreraRestController(AsignaturaPorCarreraService asigPorCarreraService) {
    this.asigPorCarreraService = asigPorCarreraService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<AsignaturaPorCarrera> createAsignaturaPorCarrera(@RequestBody AsignaturaPorCarrera asignaturaPorCarrera) {
    return new ResponseEntity<>(asigPorCarreraService
        .createAsignaturaPorCarrera(asignaturaPorCarrera), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteAsignaturaPorCarrera(@PathVariable long id) {
    asigPorCarreraService.deleteAsignaturaPorCarreraById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<AsignaturaPorCarrera> updateAsignaturaPorCarrera(@RequestBody AsignaturaPorCarrera asignaturaPorCarrera) {
    return new ResponseEntity<>(asigPorCarreraService
        .updateAsignaturaPorCarrera(asignaturaPorCarrera), HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<AsignaturaPorCarrera> getAsignaturaPorCarreraById(@PathVariable long id) {
    return new ResponseEntity<>(asigPorCarreraService
        .getAsignaturaPorCarreraById(id), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<AsignaturaPorCarrera>> getAllAsignaturasPorCarrera() {
    return new ResponseEntity<>(asigPorCarreraService
        .getAllAsignaturasPorCarrera(), HttpStatus.OK);
  }

}
