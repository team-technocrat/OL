package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.QuestionOptions;
import com.lti.model.Questions;
import com.lti.model.User;
import com.lti.services.QuestionOptionsService;
import com.lti.services.QuestionsService;
import com.lti.validators.QuestionPaperCommand;

@Controller
@RequestMapping(value = "/user/questionpaperresult")
public class QuestionPaperResultController {

	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;

	@RequestMapping(method = RequestMethod.GET)
	public String showQuestionPaperResult(Map model, HttpSession session) {
		if ((session.getAttribute("userEmail")) == null) {
			User user = new User();
			model.put("user", user);
			return "/user/userlogin";
		}
		List<QuestionPaperCommand> questionPaperList = new ArrayList<QuestionPaperCommand>();
		List questonIdList = (List) session.getAttribute("questonIdList");

		List questionlist = new ArrayList();
		for (int i = 0; i < questonIdList.size(); i++) {
			Long questionId = (Long) questonIdList.get(i);
			questionlist = questionsService
					.getQuestionsByQuestionId(questionId);
			if (questionlist != null && questionlist.size() > 0) {
				for (int j = 0; j < questionlist.size(); j++) {
					QuestionPaperCommand questionPaperCommand = new QuestionPaperCommand();
					List questionOptionsList = new ArrayList();
					Questions questions = new Questions();
					questions = (Questions) questionlist.get(j);
					questionPaperCommand.setQuestionId(questions
							.getQuestionId());
					questionPaperCommand.setQuestion(questions.getQuestion());
					// questionOptionsList
					questionOptionsList = questionOptionsService
							.getQuestionOptionsByQuesOpId(questions
									.getRightOption());
					if (questionOptionsList != null
							&& questionOptionsList.size() > 0) {
						QuestionOptions questionOptions = (QuestionOptions) questionOptionsList
								.get(0);
						questionPaperCommand.setOption1(questionOptions
								.getAnsDescription());

					}
					questionPaperList.add(questionPaperCommand);
				}
			}
		}

		model.put("questionPaperList", questionPaperList);
		model.put("totalQuestion", session.getAttribute("totalQuestion"));
		model.put("rightAnswer", session.getAttribute("rightAnswer"));
		model.put("wongAnswer", session.getAttribute("wongAnswer"));

		session.removeAttribute("totalQuestion");
		session.removeAttribute("rightAnswer");
		session.removeAttribute("wongAnswer");

		return "/user/questionpaperresult";
	}

}
