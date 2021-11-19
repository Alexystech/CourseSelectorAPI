package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Horario;
import com.slasher.CourseSelectorAPI.service.HorarioService;
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
@RequestMapping(path = "/horario")
public class HorarioRestController {

  private final HorarioService horarioService;

  @Autowired
  public HorarioRestController(HorarioService horarioService) {
    this.horarioService = horarioService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<Horario> createHorario(@RequestBody Horario horario) {
    return new ResponseEntity<>(horarioService
        .createHorario(horario), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteHorarioById(@PathVariable long id) {
    horarioService.deleteHorarioById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<Horario> updateHorario(@RequestBody Horario horario) {
    return new ResponseEntity<>(horarioService
        .updateHorario(horario), HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<Horario> getHorarioById(@PathVariable long id) {
    return new ResponseEntity<>(horarioService.getHorarioById(id), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Horario>> getAllHorarios() {
    return new ResponseEntity<>(horarioService.getAllHorarios(), HttpStatus.OK);
  }

}
