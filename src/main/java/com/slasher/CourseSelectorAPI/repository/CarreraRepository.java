package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {
}
