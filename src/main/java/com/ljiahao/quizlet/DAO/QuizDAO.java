package com.ljiahao.quizlet.DAO;

import java.util.List;

import com.ljiahao.quizlet.model.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {

	@Query(value = "SELECT * FROM Quiz_template", nativeQuery = true)
	public List<Quiz> getQuiz();
}
