package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Dia;
import com.slasher.CourseSelectorAPI.service.DiaService;
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
@RequestMapping(path = "/dia")
public class DiaRestController {

  private final DiaService diaService;

  @Autowired
  public DiaRestController(DiaService diaService) {
    this.diaService = diaService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<Dia> createDia(@RequestBody Dia dia) {
    return new ResponseEntity<>(diaService.createDia(dia), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{idDia}")
  public ResponseEntity<Boolean> deleteDiaById(@PathVariable long idDia) {
    diaService.deleteDiaById(idDia);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<Dia> updateDia(Dia dia) {
    return new ResponseEntity<>(diaService.updateDia(dia), HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{idDia}")
  public ResponseEntity<Dia> getDiaById(@PathVariable long idDia) {
    return new ResponseEntity<>(diaService.getDiaById(idDia), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Dia>> getAllDias() {
    return new ResponseEntity<>(diaService.getAllDias(), HttpStatus.OK);
  }

}
