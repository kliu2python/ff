package com.ljiahao.quizlet.DAO;

import java.util.List;

import com.ljiahao.quizlet.model.CompleteQuestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompleteQuestionDAO extends JpaRepository<CompleteQuestion, Integer> {

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO completed_questions(question_id, completed_quiz_id, chosen_option, is_correct) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
	public void saveToTable(int questionId, int completedQuizId, String chosenOption, boolean isCorrect);

	@Query(value = "SELECT * FROM completed_questions cq WHERE cq.question_id=?1 and cq.completed_quiz_id=?2", nativeQuery = true)
	public CompleteQuestion reportForUser(int questionId, int quizId);

	@Query(value = "SELECT * FROM completed_questions cq WHERE cq.completed_quiz_id=?1", nativeQuery = true)
	public List<CompleteQuestion> getAllQuestionsDoneOnQuiz(int quizId);
}
