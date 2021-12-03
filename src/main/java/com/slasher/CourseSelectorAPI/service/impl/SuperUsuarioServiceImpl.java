package com.slasher.CourseSelectorAPI.service.impl;

import com.slasher.CourseSelectorAPI.entity.SuperUsuario;
import com.slasher.CourseSelectorAPI.repository.SuperUsuarioRepository;
import com.slasher.CourseSelectorAPI.service.SuperUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperUsuarioServiceImpl implements SuperUsuarioService {

  private final SuperUsuarioRepository superUsuarioRepository;

  @Autowired
  public SuperUsuarioServiceImpl(SuperUsuarioRepository superUsuarioRepository) {
    this.superUsuarioRepository = superUsuarioRepository;
  }

  @Override
  public SuperUsuario createSuperUsuario(SuperUsuario superUsuario) {
    return superUsuarioRepository.save(superUsuario);
  }

  @Override
  public void deleteSuperUsuarioById(String idSuperUsuario) {
    superUsuarioRepository.deleteById(idSuperUsuario);
  }

  @Override
  public SuperUsuario updateSuperUsuario(SuperUsuario superUsuario) {
    return superUsuarioRepository.save(superUsuario);
  }

  @Override
  public SuperUsuario getSuperUsuarioById(String idSuperUsuario) {
    return superUsuarioRepository.findById(idSuperUsuario).get();
  }

  @Override
  public List<SuperUsuario> getAllSuperUsuarios() {
    return ((List<SuperUsuario>) superUsuarioRepository.findAll());
  }

  @Override
  public Boolean login(SuperUsuario superUsuario) {

    boolean loginAuth = getAllSuperUsuarios().stream().anyMatch(superUser ->
        superUser.getIdSuperUsuario().equals(superUsuario.getIdSuperUsuario()) &&
        superUser.getPassword().equals(superUsuario.getPassword()));

    if (loginAuth) {
      return true;
    }

    return false;
  }
}
