package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Questions;

@Repository("questionsDao")
public class QuestionsDaoImpl implements QuestionsDao {
	@Autowired
	
	@PersistenceContext
	EntityManager em;

	public List<Questions> listQuestions() {
		String q1="select q from Questions q";
		javax.persistence.TypedQuery<Questions> query=em.createQuery(q1,Questions.class);
		List<Questions> l=query.getResultList();
		
		for(Questions b:l)
		{
			System.out.println("\n\n----------"+b);
		}
			/*System.out.println("in dao");
			String ql = " from Users";
			Query q = em.createQuery(ql);
			return q.getResultList();*/
		
	return l;
	}

	@Override
	public List<Questions> getQuestionsByLanguageId(Long languageId) {
		return em
				.createQuery(
						"from Questions where languageId=:languageId ORDER BY questionId DESC")
				.setParameter("languageId", languageId).getResultList();
	}

	@Override
	public List<Questions> getQuestionsByQuestionId(Long questionId) {
		Questions q1 = em.find(Questions.class, questionId);
		return (List<Questions>) q1;
	}

	public void saveQuestions(Questions questions) 
	{
		em.persist(questions);
		
	}

	@Override
	public void updateQuestions(Questions questions) {
		em.merge(questions);
	}

	@Override
	public void deleteQuestions(Questions questions) {
		em.remove(questions);
	}

	@Override
	public List<Questions> getTenRandomQuestionsByLanguageId(Long languageId) {
		return em
				.createQuery(
						"from Questions where languageId=:languageId order by rand()")
				.setParameter("languageId", languageId).setMaxResults(10).getResultList();
	}

}
