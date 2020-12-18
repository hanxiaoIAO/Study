package study.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
	
	public Optional<UserEntity> findByCode(String code);
	
}
