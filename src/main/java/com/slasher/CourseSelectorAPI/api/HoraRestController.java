package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.Hora;
import com.slasher.CourseSelectorAPI.service.HoraService;
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
@RequestMapping(path = "/hora")
public class HoraRestController {

  private final HoraService horaService;

  @Autowired
  public HoraRestController(HoraService horaService) {
    this.horaService = horaService;
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 201, message = "created")
  })
  @PostMapping(path = "/create")
  public ResponseEntity<Hora> createHora(@RequestBody Hora hora) {
    return new ResponseEntity<>(horaService
        .createHora(hora), HttpStatus.CREATED);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteHoraById(@PathVariable long id) {
    horaService.deleteHoraById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 202, message = "accepted")
  })
  @PutMapping(path = "/update")
  public ResponseEntity<Hora> updateHora(@RequestBody Hora hora) {
    return new ResponseEntity<>(horaService
        .updateHora(hora), HttpStatus.ACCEPTED);
  }

  @ApiResponses({
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @GetMapping(path = "/get/{id}")
  public ResponseEntity<Hora> getHoraById(@PathVariable long id) {
    return new ResponseEntity<>(horaService.getHoraById(id), HttpStatus.OK);
  }

  @ApiResponse(code = 200, message = "ok")
  @GetMapping(path = "/get/all")
  public ResponseEntity<List<Hora>> getAllHoras() {
    return new ResponseEntity<>(horaService.getAllHoras(), HttpStatus.OK);
  }

}
