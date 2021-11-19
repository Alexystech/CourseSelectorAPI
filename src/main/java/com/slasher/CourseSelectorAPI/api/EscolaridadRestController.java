package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Escolaridad;
import com.slasher.CourseSelectorAPI.service.EscolaridadService;
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
@RequestMapping(path = "/escolaridad")
public class EscolaridadRestController {

  private final EscolaridadService escolaridadService;

  @Autowired
  public EscolaridadRestController(EscolaridadService escolaridadService) {
    this.escolaridadService = escolaridadService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<Escolaridad> createEscolaridad(@RequestBody Escolaridad escolaridad) {
    return new ResponseEntity<>(escolaridadService
        .createEscolaridad(escolaridad), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteEscolaridadById(@PathVariable long id) {
    escolaridadService.deleteEscolaridadById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<Escolaridad> getEscolaridadById(@PathVariable long id) {
    return new ResponseEntity<>(escolaridadService
        .getEscolaridadById(id), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Escolaridad>> getAllEscolaridades() {
    return new ResponseEntity<>(escolaridadService.getAllEscolaridades(), HttpStatus.OK);
  }

}
