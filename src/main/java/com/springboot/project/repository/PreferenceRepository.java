package com.springboot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.project.model.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
	
	List<Preference> findByUsers_Id(Long userId);

}
