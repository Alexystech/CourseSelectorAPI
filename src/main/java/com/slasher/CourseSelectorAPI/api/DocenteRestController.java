package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Docente;
import com.slasher.CourseSelectorAPI.service.DocenteService;
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
@RequestMapping(path = "/docente")
public class DocenteRestController {

  private final DocenteService docenteService;

  @Autowired
  public DocenteRestController(DocenteService docenteService) {
    this.docenteService = docenteService;
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 201, message = "created")
  })
  @PostMapping(path = "/create")
  public ResponseEntity<Docente> createDocente(@RequestBody Docente docente) {
    return new ResponseEntity<>(docenteService
        .createDocente(docente), HttpStatus.CREATED);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteDocenteById(@PathVariable String id) {
    docenteService.deleteDocenteById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 202, message = "accepted")
  })
  @PutMapping(path = "/update")
  public ResponseEntity<Docente> updateDocente(@RequestBody Docente docente) {
    return new ResponseEntity<>(docenteService
        .updateDocente(docente), HttpStatus.ACCEPTED);
  }

  @ApiResponses({
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @GetMapping(path = "/get/{id}")
  public ResponseEntity<Docente> getDocenteId(@PathVariable String id) {
    return new ResponseEntity<>(docenteService.getDocenteById(id), HttpStatus.OK);
  }

  @ApiResponse(code = 200, message = "ok")
  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Docente>> getAllDocente() {
    return new ResponseEntity<>(docenteService.getAllDocentes(), HttpStatus.OK);
  }

  @PostMapping(path = "/auth/docente")
  public ResponseEntity<Boolean> loginDocente(@RequestBody Docente docente) {
    return new ResponseEntity<>(docenteService.login(docente)
        , HttpStatus.ACCEPTED);
  }

}
