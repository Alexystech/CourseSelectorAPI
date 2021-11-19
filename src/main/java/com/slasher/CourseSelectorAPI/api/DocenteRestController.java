package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Docente;
import com.slasher.CourseSelectorAPI.service.DocenteService;
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
@RequestMapping(path = "/docente")
public class DocenteRestController {

  private final DocenteService docenteService;

  @Autowired
  public DocenteRestController(DocenteService docenteService) {
    this.docenteService = docenteService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<Docente> createDocente(@RequestBody Docente docente) {
    return new ResponseEntity<>(docenteService
        .createDocente(docente), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteDocenteById(@PathVariable String id) {
    docenteService.deleteDocenteById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<Docente> updateDocente(@RequestBody Docente docente) {
    return new ResponseEntity<>(docenteService
        .updateDocente(docente), HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<Docente> getDocenteId(@PathVariable String id) {
    return new ResponseEntity<>(docenteService.getDocenteById(id), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Docente>> getAllDocente() {
    return new ResponseEntity<>(docenteService.getAllDocentes(), HttpStatus.OK);
  }

}
