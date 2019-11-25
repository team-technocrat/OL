package com.lti.validators;

public class AddQuestionForm {
	   Long  questionId;
	   Long languageId;
	   String question;
	   Long rightOption;
	   String option1;
	   String option2;
	   String option3;
	   String option4;
	   
	   public void setQuestionId(Long questionId){
		   this.questionId = questionId;
		}	   
	   public Long getQuestionId(){
		      return questionId;
		 }
	   
	   public void setLanguageId(Long languageId) {
		      this.languageId = languageId;
		 }
	   public Long getLanguageId() {
		      return languageId;
		}
	   
	   public void setQuestion(String question){
		      this.question = question;
		 }
	   public String getQuestion(){
		      return question;
		 }
	   
	   public void setRightOption(Long rightOption){
		      this.rightOption = rightOption;
		   }
	   public Long getRightOption() {
		      return rightOption;
		   }
	   
	   public void setOption1(String option1){
		      this.option1 = option1;
		 }
	   public String getOption1(){
		      return option1;
		 }
	   public void setOption2(String option2){
		      this.option2 = option2;
		 }
	   public String getOption2(){
		      return option2;
		 }
	   
	   public void setOption3(String option3){
		      this.option3 = option3;
		 }
	   public String getOption3(){
		      return option3;
		 }
	   
	   public void setOption4(String option4){
		      this.option4 = option4;
		 }
	   public String getOption4(){
		      return option4;
		 }
	@Override
	public String toString() {
		return "AddQuestionForm [questionId=" + questionId + ", languageId=" + languageId + ", question=" + question
				+ ", rightOption=" + rightOption + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + "]";
	}
	public AddQuestionForm(Long questionId, Long languageId, String question, Long rightOption, String option1,
			String option2, String option3, String option4) {
		super();
		this.questionId = questionId;
		this.languageId = languageId;
		this.question = question;
		this.rightOption = rightOption;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
	public AddQuestionForm() {
		super();
	}	 
	   
 }

