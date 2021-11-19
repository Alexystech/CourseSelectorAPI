package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Carrera;
import com.slasher.CourseSelectorAPI.service.CarreraService;
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
@RequestMapping(path = "/carrera")
public class CarreraRestController {

  private final CarreraService carreraService;

  @Autowired
  public CarreraRestController(CarreraService carreraService) {
    this.carreraService = carreraService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<Carrera> createCarrera(@RequestBody Carrera carrera) {
    return new ResponseEntity<>(carreraService
        .createCarrera(carrera), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteCarreraById(@PathVariable long id) {
    carreraService.deleteCarreraById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<Carrera> updateCarrera(Carrera carrera) {
    return new ResponseEntity<>(carreraService
        .updateCarrera(carrera), HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<Carrera> getCarreraById(@PathVariable long id) {
    return new ResponseEntity<>(carreraService.getCarreraById(id), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Carrera>> getAllCarreras() {
    return new ResponseEntity<>(carreraService.getAllCarreras(), HttpStatus.OK);
  }

}
