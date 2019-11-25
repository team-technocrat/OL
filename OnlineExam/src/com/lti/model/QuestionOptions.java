package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "question_options")
public class QuestionOptions {

@Id
@GeneratedValue
Long quesOpId;
String ansDescription;
Long questionId;

public void setQuesOpId(Long quesOpId) 
{
this.quesOpId = quesOpId;
}

public Long getQuesOpId() {
return quesOpId;
}

public void setAnsDescription(String ansDescription) {
this.ansDescription = ansDescription;
}

public String getAnsDescription() {
return ansDescription;
}

public void setQuestionId(Long questionId) {
this.questionId = questionId;
}

public Long getQuestionId() {
return questionId;
}

@Override
public String toString() {
	return "QuestionOptions [quesOpId=" + quesOpId + ", ansDescription=" + ansDescription + ", questionId=" + questionId
			+ "]";
}

public QuestionOptions(Long quesOpId, String ansDescription, Long questionId) {
	super();
	this.quesOpId = quesOpId;
	this.ansDescription = ansDescription;
	this.questionId = questionId;
}

public QuestionOptions() {
	super();
}


}