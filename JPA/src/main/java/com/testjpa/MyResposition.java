package com.testjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyResposition extends JpaRepository<StudentEntity, Long>{


}
