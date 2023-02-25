package com.onlyjavatech.springbootproject.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlyjavatech.springbootproject.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
