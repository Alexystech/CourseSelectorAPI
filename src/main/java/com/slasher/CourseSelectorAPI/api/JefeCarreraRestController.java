package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.JefeCarrera;
import com.slasher.CourseSelectorAPI.service.JefeCarreraService;
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
@RequestMapping(path = "/jefe-carrera")
public class JefeCarreraRestController {

  private final JefeCarreraService jefeCarreraService;

  @Autowired
  public JefeCarreraRestController(JefeCarreraService jefeCarreraService) {
    this.jefeCarreraService = jefeCarreraService;
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 201, message = "created")
  })
  @PostMapping(path = "/create")
  public ResponseEntity<JefeCarrera> createJefeCarrera(@RequestBody JefeCarrera jefeCarrera) {
    return new ResponseEntity<>(jefeCarreraService
        .createJefeCarrera(jefeCarrera), HttpStatus.CREATED);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteJefeCarreraById(@PathVariable String id) {
    jefeCarreraService.deleteJefeCarreraById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 202, message = "accepted")
  })
  @PutMapping(path = "/update")
  public ResponseEntity<JefeCarrera> updateJefeCarrera(@RequestBody JefeCarrera jefeCarrera) {
    return new ResponseEntity<>(jefeCarreraService
        .updateJefeCarrera(jefeCarrera), HttpStatus.ACCEPTED);
  }

  @ApiResponses({
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @GetMapping(path = "/get/{id}")
  public ResponseEntity<JefeCarrera> getJefeCarreraById(@PathVariable String id) {
    return new ResponseEntity<>(jefeCarreraService
        .getJefeCarreraById(id), HttpStatus.OK);
  }

  @ApiResponse(code = 200, message = "ok")
  @GetMapping(path = "/get/all")
  public ResponseEntity<List<JefeCarrera>> getAllJefesCarrera() {
    return new ResponseEntity<>(jefeCarreraService.getAllJefesCarrera(), HttpStatus.OK);
  }

  @PostMapping(path = "/auth/jefe-carrera")
  public ResponseEntity<Boolean> loginJefeCarrera(@RequestBody JefeCarrera jefeCarrera) {
    return new ResponseEntity<>(jefeCarreraService.login(jefeCarrera)
        , HttpStatus.ACCEPTED);
  }

}
