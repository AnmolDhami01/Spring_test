package com.onlyjavatech.springbootproject.model.repo;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlyjavatech.springbootproject.model.Students;

public interface StudentRepo extends JpaRepository<Students, Integer> {

	public List<Students> findByAge(String age);

	public List<Students> findByAgeAndClass1(String age, String class1);
	
//	@Query("SELECT e FROM Students e WHERE u.class1 =:n and u.city=:c");
//	public List<Students> findByCreationDate(@Param("n") String createdAt,@Param("c") String city);
//	@Query("SELECT e FROM Students e WHERE DATE_FORMAT(e.createdAt, '%Y-%m-%d') =:n")
	@Query(value="SELECT * FROM students e WHERE DATE_FORMAT(?1, '%Y-%m-%d')",nativeQuery = true)
	public List<Students> findByCreationDate(@Param("n") String createdAt);

}
 