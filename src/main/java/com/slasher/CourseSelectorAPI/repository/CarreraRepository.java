package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

    @Query(value = "SELECT c FROM Carrera c WHERE c.jefeCarrera.idJefeCarrera = :idJefeCarrera")
    Carrera findCarrerasByIdJefeCarrera(@Param("idJefeCarrera") String idJefeCarrera);

}
