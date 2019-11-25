package com.lti.repository;	

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.QuestionOptions;

@Repository("questionOptionsDao")
public class QuestionOptionsDaoImpl implements QuestionOptionsDao {
	@Autowired
	EntityManager em;

	public List<QuestionOptions> listQuestionOptions() {
		return em.createQuery(
				"from QuestionOptions where quesOpId=1").getResultList();
	}

	@Override
	public List<QuestionOptions> getQuestionOptionsByQuestionId(Long questionId) {
		return em.createQuery(
				"from QuestionOptions where questionId=:questionId")
				.setParameter("questionId", questionId).getResultList();
	}

	@Override
	public List<QuestionOptions> getQuestionOptionsByQuesOpId(Long quesOpId) {
		return em.createQuery(
				"from QuestionOptions where quesOpId=:quesOpId").setParameter(
				"quesOpId", quesOpId).getResultList();
	}

	@Override
	public void saveQuestionOptions(QuestionOptions questionOptions) {
		em.merge(questionOptions);
	}

	@Override
	public void updateQuestionOptions(QuestionOptions questionOptions) {
		em
				.createQuery(
						"UPDATE QuestionOptions  SET ansDescription=:ansDescription ,questionId=:questionId where quesOpId=:quesOpId")
				.setParameter("ansDescription",
						questionOptions.getAnsDescription()).setParameter(
						"questionId", questionOptions.getQuestionId())
				.setParameter("quesOpId", questionOptions.getQuesOpId())
				.executeUpdate();
	}

	@Override
	public void deleteQuestionOptionsByQuestionId(Long questionId) {
		em.remove(questionId);
	}
}
