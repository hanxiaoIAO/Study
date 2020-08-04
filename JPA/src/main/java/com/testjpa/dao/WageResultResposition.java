package com.testjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WageResultResposition extends JpaRepository<WageResultEntity, Long>{


}
