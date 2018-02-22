package com.abebe.demo.repo;

import com.abebe.demo.model.Jobs;
import org.springframework.data.repository.CrudRepository;

public interface JobsRepository extends CrudRepository<Jobs,Long> {
}
