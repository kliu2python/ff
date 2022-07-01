package com.example.demo1.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {
	
	@Query(value = "SELECT * FROM Quiz_template", nativeQuery = true)
	public List<Quiz> getQuiz();
}
