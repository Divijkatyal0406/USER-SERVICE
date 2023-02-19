package com.sp.micro.user_s.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.micro.user_s.entities.User;

public interface UserRepo extends JpaRepository<User, String>{

}
