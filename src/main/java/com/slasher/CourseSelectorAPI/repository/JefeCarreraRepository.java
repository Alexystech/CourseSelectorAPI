package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.JefeCarrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JefeCarreraRepository extends CrudRepository<JefeCarrera, String> {
  /**
   * el query esta mal, no retorna lo que debe
   * @return
   */
  @Query(value = "select jc.id_jefe_de_carrera, jc.password, jc.nombre, jc.apellido_paterno, jc.apellido_materno, jc.rfc, jc.curp, jc.domicilio, jc.nss from jefes_de_carrera jc inner join carreras c on jc.id_jefe_de_carrera != c.fk_id_jefe_carrera;", nativeQuery = true)
  List<JefeCarrera> findJefesCarreraFilteredByIdJefeCarreraInCarreras();
}
