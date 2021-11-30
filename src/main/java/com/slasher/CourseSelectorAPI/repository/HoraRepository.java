package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.Hora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraRepository extends CrudRepository<Hora, Long> {
}
