package com.lti.repository;

import java.util.List;

import com.lti.model.Questions;

public interface QuestionsDao {
	public List<Questions> listQuestions();

	public List<Questions> getQuestionsByLanguageId(Long languageId);

	public List<Questions> getQuestionsByQuestionId(Long questionId);

	public void saveQuestions(Questions questions);

	public void updateQuestions(Questions questions);

	public void deleteQuestions(Questions questions);

	public List<Questions> getTenRandomQuestionsByLanguageId(Long languageId);

}
