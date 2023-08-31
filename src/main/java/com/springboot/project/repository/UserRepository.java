package com.springboot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	
	@Query(value = "SELECT * FROM user WHERE "
			+ "LOWER(first_name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(last_name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(email) LIKE LOWER(CONCAT('%', :keyword, '%'))", nativeQuery = true)
	List<User> findByKeyword(@Param("keyword") String keyword);

}
