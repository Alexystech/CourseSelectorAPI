package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;
import com.slasher.CourseSelectorAPI.util.AsigHorarioDefByDocente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsigHorarioDefRepository extends CrudRepository<AsigHorarioDef, Long> {

  @Query(value = "SELECT new com.slasher.CourseSelectorAPI.util.AsigHorarioDefByDocente(asig.semestre, asig.idHora.hora, asig.idAsignatura.nombreAsignatura) FROM AsigHorarioDef asig WHERE asig.idDocente.idDocente = :idDocente")
  List<AsigHorarioDefByDocente> findAsigHorariosByIdDocente(@Param("idDocente") String idDocente);

  @Query(value = "SELECT a FROM AsigHorarioDef a WHERE a.idDocente.idDocente = :idDocente")
  List<AsigHorarioDef> findAsigHorarioDefByIdDocente(@Param("idDocente") String idDocente);

}
