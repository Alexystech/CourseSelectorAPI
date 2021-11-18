package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.AsignaturaPorCarrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaPorCarreraRepository extends CrudRepository<AsignaturaPorCarrera, Long> {
}
