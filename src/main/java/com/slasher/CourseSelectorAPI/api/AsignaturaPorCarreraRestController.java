package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;
import com.slasher.CourseSelectorAPI.service.AsignaturaPorCarreraService;
import com.slasher.CourseSelectorAPI.util.MateriasDisponibles;
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
@RequestMapping(path = "/asignatura-por-carrera")
public class AsignaturaPorCarreraRestController {

  private final AsignaturaPorCarreraService asigPorCarreraService;

  @Autowired
  public AsignaturaPorCarreraRestController(AsignaturaPorCarreraService asigPorCarreraService) {
    this.asigPorCarreraService = asigPorCarreraService;
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 201, message = "created")
  })
  @PostMapping(path = "/create")
  public ResponseEntity<AsignaturaPorCarrera> createAsignaturaPorCarrera(@RequestBody AsignaturaPorCarrera asignaturaPorCarrera) {
    return new ResponseEntity<>(asigPorCarreraService
        .createAsignaturaPorCarrera(asignaturaPorCarrera), HttpStatus.CREATED);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> deleteAsignaturaPorCarrera(@PathVariable long id) {
    asigPorCarreraService.deleteAsignaturaPorCarreraById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @ApiResponses({
      @ApiResponse(code = 422, message = "unprocessable entity"),
      @ApiResponse(code = 202, message = "accepted")
  })
  @PutMapping(path = "/update")
  public ResponseEntity<AsignaturaPorCarrera> updateAsignaturaPorCarrera(@RequestBody AsignaturaPorCarrera asignaturaPorCarrera) {
    return new ResponseEntity<>(asigPorCarreraService
        .updateAsignaturaPorCarrera(asignaturaPorCarrera), HttpStatus.ACCEPTED);
  }

  @ApiResponses({
      @ApiResponse(code = 404, message = "entity was not found"),
      @ApiResponse(code = 200, message = "ok")
  })
  @GetMapping(path = "/get/{id}")
  public ResponseEntity<AsignaturaPorCarrera> getAsignaturaPorCarreraById(@PathVariable long id) {
    return new ResponseEntity<>(asigPorCarreraService
        .getAsignaturaPorCarreraById(id), HttpStatus.OK);
  }

  @ApiResponse(code = 200, message = "ok")
  @GetMapping(path = "/get/all")
  public ResponseEntity<List<AsignaturaPorCarrera>> getAllAsignaturasPorCarrera() {
    return new ResponseEntity<>(asigPorCarreraService
        .getAllAsignaturasPorCarrera(), HttpStatus.OK);
  }

  @GetMapping(path = "/get/all/asignaturas/disponibles")
  public ResponseEntity<List<MateriasDisponibles>> getMateriasDisponibles() {
    return new ResponseEntity<>(asigPorCarreraService.getMateriasDisponibles()
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/asignaturas/by/{semestre}")
  public ResponseEntity<List<AsignaturaPorCarrera>> getAsignaturasBySemestre(@PathVariable int semestre) {
    return new ResponseEntity<>(asigPorCarreraService.getAsignaturasBySemestre(semestre)
        , HttpStatus.OK);
  }
}
