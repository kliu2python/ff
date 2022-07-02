package com.ljiahao.quizlet.DAO;

import java.util.List;

import com.ljiahao.quizlet.model.CompleteQuiz;
import com.ljiahao.quizlet.model.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompleteQuizDAO extends JpaRepository<CompleteQuiz, Integer> {

	@Query(value = "SELECT * FROM completed_quiz cq WHERE cq.user_id=?1", nativeQuery = true)
	public List<CompleteQuiz> getQuizDone(int userid);

	@Query(value = "SELECT max(id) FROM completed_quiz", nativeQuery = true)
	public int getMaxId();

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO completed_quiz(user_id, template_id, start_date, finish_date, score) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	public void saveToTable(int userId, int quizId, String StartDate, String finshDate, int score);
}
