package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Semestre;
import com.slasher.CourseSelectorAPI.service.SemestreService;
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
@RequestMapping(path = "/semestre")
public class SemestreRestController {

  private final SemestreService semestreService;

  @Autowired
  public SemestreRestController(SemestreService semestreService) {
    this.semestreService = semestreService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<Semestre> createSemestre(@RequestBody Semestre semestre) {
    return new ResponseEntity<>(semestreService.createSemestre(semestre), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{idSemestre}")
  public ResponseEntity<Boolean> deleteSemestreById(@PathVariable long idSemestre) {
    semestreService.deleteSemestreById(idSemestre);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<Semestre> updateSemestre(@RequestBody Semestre semestre) {
    return new ResponseEntity<>(semestreService.updateSemestre(semestre), HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{idSemestre}")
  public ResponseEntity<Semestre> getSemestreById(@PathVariable long idSemestre) {
    return new ResponseEntity<>(semestreService.getSemestreById(idSemestre), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Semestre>> getAllSemestres() {
    return new ResponseEntity<>(semestreService.getAllSemestres(), HttpStatus.OK);
  }

}
