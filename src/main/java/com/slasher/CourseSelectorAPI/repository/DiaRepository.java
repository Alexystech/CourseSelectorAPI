package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.Dia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends CrudRepository<Dia, Long> {
}
