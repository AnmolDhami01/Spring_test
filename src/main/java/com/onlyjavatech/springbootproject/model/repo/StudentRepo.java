package com.onlyjavatech.springbootproject.model.repo;


import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlyjavatech.springbootproject.model.Students;

public interface StudentRepo extends JpaRepository<Students, Integer> {

	public List<Students> findByAge(String age);

	public List<Students> findByAgeAndClass1(String age, String class1);

	@Query("SELECT * FROM students WHERE DATE (created_at)  =:createdAt")
	public List<Students> findByCreationDate(Locale createdAt);

}
