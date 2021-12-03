package com.slasher.CourseSelectorAPI.service;

import com.slasher.CourseSelectorAPI.entity.SuperUsuario;

import java.util.List;

public interface SuperUsuarioService {
  SuperUsuario createSuperUsuario(SuperUsuario superUsuario);
  void deleteSuperUsuarioById(String idSuperUsuario);
  SuperUsuario updateSuperUsuario(SuperUsuario superUsuario);
  SuperUsuario getSuperUsuarioById(String idSuperUsuario);
  List<SuperUsuario> getAllSuperUsuarios();
  Boolean login(SuperUsuario superUsuario);
}
