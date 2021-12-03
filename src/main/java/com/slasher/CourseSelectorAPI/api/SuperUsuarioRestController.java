package com.slasher.CourseSelectorAPI.api;

import com.slasher.CourseSelectorAPI.entity.SuperUsuario;
import com.slasher.CourseSelectorAPI.service.SuperUsuarioService;
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
@RequestMapping(path = "/super-usuario")
public class SuperUsuarioRestController {

  private final SuperUsuarioService superUsuarioService;

  @Autowired
  public SuperUsuarioRestController(SuperUsuarioService superUsuarioService) {
    this.superUsuarioService = superUsuarioService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<SuperUsuario> createSuperUsuario(@RequestBody SuperUsuario superUsuario) {
    return new ResponseEntity<>(superUsuarioService.createSuperUsuario(superUsuario)
        , HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/delete/{idSuperUsuario}")
  public ResponseEntity<Boolean> deleteSuperUsuarioById(@PathVariable String idSuperUsuario) {
    superUsuarioService.deleteSuperUsuarioById(idSuperUsuario);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<SuperUsuario> updateSuperUsuario(@RequestBody SuperUsuario superUsuario) {
    return new ResponseEntity<>(superUsuarioService.updateSuperUsuario(superUsuario)
        , HttpStatus.ACCEPTED);
  }

  @GetMapping(path = "/get/{idSuperUsuario}")
  public ResponseEntity<SuperUsuario> getSuperUsuarioById(@PathVariable String idSuperUsuario) {
    return new ResponseEntity<>(superUsuarioService.getSuperUsuarioById(idSuperUsuario)
        , HttpStatus.OK);
  }

  @GetMapping(path = "/get/all")
  public ResponseEntity<List<SuperUsuario>> getAllSuperUsuarios() {
    return new ResponseEntity<>(superUsuarioService.getAllSuperUsuarios()
        , HttpStatus.OK);
  }

  @PostMapping(path = "/auth/su")
  public ResponseEntity<Boolean> loginSuperUsuario(@RequestBody SuperUsuario superUsuario) {
    return new ResponseEntity<>(superUsuarioService.login(superUsuario)
        , HttpStatus.ACCEPTED);
  }

}
