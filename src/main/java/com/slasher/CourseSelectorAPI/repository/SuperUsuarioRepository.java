package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.SuperUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperUsuarioRepository extends CrudRepository<SuperUsuario, String> {
}
