package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {

@Id
@GeneratedValue
Long questionId;
Long languageId;
String question;
Long rightOption;

public void setQuestionId(Long questionId) {
this.questionId = questionId;
}

public Long getQuestionId() {
return questionId;
}

public void setLanguageId(Long languageId) {
this.languageId = languageId;
}

public Long getLanguageId() {
return languageId;
}

public void setQuestion(String question) {
this.question = question;
}

public String getQuestion() {
return question;
}

public void setRightOption(Long rightOption) {
this.rightOption = rightOption;
}

public Long getRightOption() {
return rightOption;
}
}