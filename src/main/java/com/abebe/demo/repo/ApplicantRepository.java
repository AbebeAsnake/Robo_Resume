package com.abebe.demo.repo;

import com.abebe.demo.model.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant,Long> {
}
