package com.example.demo.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}