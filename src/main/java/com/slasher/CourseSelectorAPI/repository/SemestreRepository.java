package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.Semestre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreRepository extends CrudRepository<Semestre, Long> {
}
