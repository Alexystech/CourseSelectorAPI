package com.slasher.CourseSelectorAPI.repository;

import com.slasher.CourseSelectorAPI.entity.AsigHorarioDef;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsigHorarioDefRepository extends CrudRepository<AsigHorarioDef, Long> {
}
