package com.onlyjavatech.springbootproject.model.repo;




import org.springframework.data.jpa.repository.JpaRepository;

import com.onlyjavatech.springbootproject.model.AuthourModel;



public interface AuthourRepo extends JpaRepository<AuthourModel, Integer> {

	

}
 