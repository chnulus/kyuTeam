package com.gwt.kyu.shared;

public class Exam {

	private String Question;
	private String[] Answers;
	private String CorrectAnswer;

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String[] getAnswers() {
		return Answers;
	}

	public void setAnswers(String[] answers) {
		Answers = answers;
	}

	public String getCorrectAnswer() {
		return CorrectAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		CorrectAnswer = correctAnswer;
	}

}
