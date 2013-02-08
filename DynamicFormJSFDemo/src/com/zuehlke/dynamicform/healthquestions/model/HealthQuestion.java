package com.zuehlke.dynamicform.healthquestions.model;

import java.util.Collection;

public class HealthQuestion {

	private String id;
	private String questionText;
	private boolean baseQuestion;
	private Collection<HealthQuestion> subQuestions;
	private String textAnswer;
	private boolean yesNoQuestion;
	private Boolean yesNoAnswer;

	public HealthQuestion(String id, String questionText, boolean baseQuestion,
			Collection<HealthQuestion> subQuestions, boolean yesNoQuestion) {
		this.id = id;
		this.questionText = questionText;
		this.baseQuestion = baseQuestion;
		this.subQuestions = subQuestions;
		this.yesNoQuestion = yesNoQuestion;
	}

	public String getTextAnswer() {
		return textAnswer;
	}

	public void setTextAnswer(String textAnswer) {
		this.textAnswer = textAnswer;
	}

	public Boolean getYesNoAnswer() {
		return yesNoAnswer;
	}

	public void setYesNoAnswer(Boolean yesNoAnswer) {
		this.yesNoAnswer = yesNoAnswer;
	}

	public String getQuestionText() {
		return questionText;
	}

	public boolean isBaseQuestion() {
		return baseQuestion;
	}

	public Collection<HealthQuestion> getSubQuestions() {
		return subQuestions;
	}

	public boolean isYesNoQuestion() {
		return yesNoQuestion;
	}

	public String getId() {
		return id;
	}

	public String getAnswerAsString() {
		String answerAsString = "";
		if (yesNoQuestion) {
			if (yesNoAnswer != null) {
				answerAsString = yesNoAnswer ? "Ja" : "Nein";
			}
		} else {
			answerAsString = textAnswer;
		}
		return answerAsString;
	}

}
