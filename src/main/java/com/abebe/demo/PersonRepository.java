package com.abebe.demo;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<References,Long> {
}
