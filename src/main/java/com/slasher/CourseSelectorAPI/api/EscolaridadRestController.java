package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Escolaridad;
import com.slasher.CourseSelectorAPI.service.EscolaridadService;
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
@RequestMapping(path = "/escolaridad")
public class EscolaridadRestController {

  private final EscolaridadService escolaridadService;

  @Autowired
  public EscolaridadRestController(EscolaridadService escolaridadService) {
    this.escolaridadService = escolaridadService;
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 201, message = "created")
  })
  @PostMapping(path = "/create")
  public ResponseEntity<Escolaridad> createEscolaridad(@RequestBody Escolaridad escolaridad) {
    return new ResponseEntity<>(escolaridadService
        .createEscolaridad(escolaridad), HttpStatus.CREATED);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteEscolaridadById(@PathVariable long id) {
    escolaridadService.deleteEscolaridadById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 202, message = "accepted")
  })
  @PutMapping(path = "/update")
  public ResponseEntity<Escolaridad> updateEscolaridad(@RequestBody Escolaridad escolaridad) {
    return new ResponseEntity<>(escolaridadService
        .updateEscolaridad(escolaridad), HttpStatus.ACCEPTED);
  }

  @ApiResponses({
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @GetMapping(path = "/get/{id}")
  public ResponseEntity<Escolaridad> getEscolaridadById(@PathVariable long id) {
    return new ResponseEntity<>(escolaridadService
        .getEscolaridadById(id), HttpStatus.OK);
  }

  @ApiResponse(code = 200, message = "ok")
  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Escolaridad>> getAllEscolaridades() {
    return new ResponseEntity<>(escolaridadService.getAllEscolaridades(), HttpStatus.OK);
  }

  @GetMapping(path = "/get/by/docente/{idDocente}")
  public ResponseEntity<List<Escolaridad>> getEscolaridadesByIdDocente(@PathVariable String idDocente) {
    return new ResponseEntity<>(escolaridadService.getEscolaridadesByIdDocente(idDocente)
        , HttpStatus.OK);
  }

}
