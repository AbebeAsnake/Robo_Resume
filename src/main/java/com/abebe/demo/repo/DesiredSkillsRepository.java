package com.abebe.demo.repo;

import com.abebe.demo.model.DesiredSkills;
import org.springframework.data.repository.CrudRepository;

public interface DesiredSkillsRepository extends CrudRepository<DesiredSkills,Long> {
    DesiredSkills findById(long id);
}
