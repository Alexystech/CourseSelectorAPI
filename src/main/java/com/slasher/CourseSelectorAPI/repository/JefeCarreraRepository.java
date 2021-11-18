package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.JefeCarrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JefeCarreraRepository extends CrudRepository<JefeCarrera, String> {
}
