package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.SolicitudMateria;
import com.slasher.CourseSelectorAPI.util.MateriasSolicitadas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudMateriaRespository extends CrudRepository<SolicitudMateria, Long> {

  @Query(value = "SELECT new com.slasher.CourseSelectorAPI.util.MateriasSolicitadas(materia.asignaturaPorCarrera.idAsignatura.nombreAsignatura, materia.asignaturaPorCarrera.idSemestre.semestre, materia.asignaturaPorCarrera.idCarrera.nombreCarrera) FROM SolicitudMateria materia WHERE materia.docente.idDocente = :idDocente")
  List<MateriasSolicitadas> findAllMateriasSolicitadas(@Param("idDocente") String idDocente);

  @Query(value = "SELECT s FROM SolicitudMateria s WHERE s.asignaturaPorCarrera.idAsigPorCarrera = :asignaturaPorCarrera")
  List<SolicitudMateria> findSolicitudesByMateria(@Param("asignaturaPorCarrera") long asignaturaPorCarrera);

  @Query(value = "SELECT s FROM SolicitudMateria s WHERE s.docente.idDocente = :idDocente")
  List<SolicitudMateria> findSolicitudMateriaByIdDocente(@Param("idDocente") String idDocente);
}
