package com.ljiahao.quizlet.DAO;

import java.util.List;

import com.ljiahao.quizlet.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

	@Query(value = "SELECT * FROM Question q WHERE q.id = ?1", nativeQuery = true)
	public Question findById(int theId);

	@Query(value = "SELECT * FROM Question q WHERE q.quiz_id = ?1", nativeQuery = true)
	public List<Question> getAllQuizs(int theType);
}
