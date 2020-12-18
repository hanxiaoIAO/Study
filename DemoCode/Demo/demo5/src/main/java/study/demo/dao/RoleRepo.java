package study.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEntity,Integer> {
	
	public Optional<RoleEntity> findByCode(String code);
	
}
