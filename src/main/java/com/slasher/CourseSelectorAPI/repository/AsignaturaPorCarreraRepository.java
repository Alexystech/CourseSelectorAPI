package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;
import com.slasher.CourseSelectorAPI.util.MateriasDisponibles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaPorCarreraRepository extends CrudRepository<AsignaturaPorCarrera, Long> {

  @Query(value = "SELECT new com.slasher.CourseSelectorAPI.util.MateriasDisponibles(asignatura.idAsigPorCarrera, asignatura.idAsignatura.nombreAsignatura) FROM AsignaturaPorCarrera asignatura")
  List<MateriasDisponibles> findMateriasDisponibles();

  @Query(value = "SELECT a FROM AsignaturaPorCarrera a WHERE a.idSemestre.semestre = :semestre AND a.idCarrera.jefeCarrera.idJefeCarrera = :idJefeCarrera")
  List<AsignaturaPorCarrera> findAsignaturasBySemestre(@Param("semestre") int semestre, @Param("idJefeCarrera") String idJefeCarrera);

  @Query(value = "SELECT a FROM AsignaturaPorCarrera a WHERE a.idCarrera.idCarrera = :idCarrera")
  List<AsignaturaPorCarrera> findAsignturaPorCarreaByCarrera(@Param("idCarrera") long idCarrera);

  @Query(value = "SELECT a FROM AsignaturaPorCarrera a WHERE a.idAsignatura.idAsignatura = :idAsignatura")
  AsignaturaPorCarrera findAsignaturaPorCarreraByIdAsignatura(@Param("idAsignatura") long idAsignatura);

}
