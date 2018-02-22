package com.abebe.demo.repo;

import com.abebe.demo.model.Education;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education,Long> {
}
