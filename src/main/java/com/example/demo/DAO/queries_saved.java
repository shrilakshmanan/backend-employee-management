package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.Querymails;
import com.example.demo.MODEL.leaveDates;


@Repository
public interface queries_saved extends JpaRepository<Querymails , Integer>{

	
	@Query( value = "SELECT * FROM querymail u WHERE u.queryid = ?1", 	
			  nativeQuery = true)
	Optional<Querymails> findByqueryid(int id);

	
	@Query( value = "SELECT * FROM querymail u WHERE u.ids = ?1", 	
			  nativeQuery = true)

	List<Querymails> findByepid(int id);

	@Query( value = "SELECT COUNT(ids) FROM querymail",  nativeQuery = true)
	long querycountcounts(int id);

	@Query( value = "SELECT COUNT(status) FROM querymail  WHERE ids=?1 AND status=?2",  nativeQuery = true)
	long findByempquery(Integer id, String status);

	@Query( value = "SELECT * FROM querymail u WHERE u.queryid = ?1", 	
			  nativeQuery = true)
	Querymails updatequery(int id);

	@Query( value = "SELECT * FROM querymail u WHERE u.queryid = ?1", 	
			  nativeQuery = true)
	Querymails findbyqueryid(int id);

	@Query( value = "SELECT COUNT(queryid) FROM querymail  WHERE ids=?1",  nativeQuery = true)
	long findByAllempquery(int id);

	@Query( value = "SELECT COUNT(queryid) FROM querymail  WHERE ids=?1",  nativeQuery = true)
	long findqueries(int id);

	@Query( value = "SELECT COUNT(status) FROM querymail  WHERE ids=?1 AND status=?2",  nativeQuery = true)
	long findacceptqueries(int id, String status1);

	@Query( value = "SELECT COUNT(status) FROM querymail  WHERE ids=?1 AND status=?2",  nativeQuery = true)
	long findRejectqueries(int id, String status1);

	@Query( value = "SELECT COUNT(status) FROM querymail  WHERE ids=?1 AND status=?2",  nativeQuery = true)
	int getactivecount(int id,String status);

	@Query( value = "SELECT COUNT(status) FROM querymail  WHERE ids=?1 AND status = ?2",  nativeQuery = true)
	int getquerycount(int id, String status);

	@Query( value = "SELECT COUNT(status) FROM querymail",  nativeQuery = true)
	int getTotquery();


	@Query( value = "SELECT COUNT(status) FROM querymail  WHERE ids=?1 AND status != ?2",  nativeQuery = true)
	
	int getqueryReject(int id, String reject);

	@Query( value = "SELECT COUNT(status) FROM querymail  WHERE ids=?1 AND status = ?2",  nativeQuery = true)

	int getrejectquerycount(int id, String rejectadm);


	
	
}
