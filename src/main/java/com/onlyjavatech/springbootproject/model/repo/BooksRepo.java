package com.onlyjavatech.springbootproject.model.repo;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlyjavatech.springbootproject.model.BooksModel;


public interface BooksRepo extends JpaRepository<BooksModel, Integer> {

	

}
 