package com.onlyjavatech.springbootproject.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlyjavatech.springbootproject.model.Students;

public interface StudentRepo extends JpaRepository<Students,Integer> {
	
	public List<Students> findByAge(String age);

}
