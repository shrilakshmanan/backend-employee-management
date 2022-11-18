package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.pojo_cls;

@Repository
public interface Repost_cls extends  JpaRepository< pojo_cls, Integer>  {

	
}
