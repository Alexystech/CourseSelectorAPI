package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.AsignacionHorario;
import com.slasher.CourseSelectorAPI.util.Horario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionHorarioRepository extends CrudRepository<AsignacionHorario, Long> {

  @Query(value = "SELECT new com.slasher.CourseSelectorAPI.util.Horario(horario.idHora.dia.nombreDia, horario.idHora.hora) FROM AsignacionHorario horario WHERE horario.idDocente.idDocente = :idDocente")
  List<Horario> findAllAsignacionesByIdDocente(@Param("idDocente") String idDocente);

}
