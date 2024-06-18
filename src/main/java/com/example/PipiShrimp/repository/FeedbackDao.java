
package com.example.PipiShrimp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PipiShrimp.entity.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

	@Query(value = "select * from feedback where name like %:name% and "
			+ "phone like %:phone% "
			+ "and email like %:email%", nativeQuery = true)
	public List<Feedback> searchFeedbackByUser(
			@Param("name") String name,
			@Param("phone") String phone,
			@Param("email") String email);
	
	
	@Query(value = "select * from feedback where name like %:name% ", nativeQuery = true)
	public List<Feedback> searchNameLike(@Param("name") String name);
	
}
