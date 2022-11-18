package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.leaveDates;

@Repository
public interface takingdataleavereposit extends CrudRepository<leaveDates, Integer>, PagingAndSortingRepository<leaveDates, Integer> {
 
	int ids=9;
	
    @Query(value="select * from leavedates  a where a.ids= :ids", nativeQuery=true)
    List<leaveDates> getAuthorsByFirstName(int ids);
 
 
}