package com.jwtExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jwtExample.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
