package su.nepom;

import java.util.List;

public class Question {
	private final String text;
	private final String[] answers;
	private final int validAnswerNo;

	public Question(String text, String[] answers, int validAnswerNo) {
		this.text = text;
		this.answers = answers;
		this.validAnswerNo = validAnswerNo;
	}

	public String getText() {
		return text;
	}

	public String[] getAnswers() {
		return answers;
	}

	public int getValidAnswerNo() {
		return validAnswerNo;
	}

	@Override
	public String toString() {
		return "Question{" +
				"text='" + text + '\'' +
				", answers=" + answers +
				", validAnswerNo=" + validAnswerNo +
				'}';
	}

	public boolean isValidAnswer(int answerNo) {
		return answerNo == validAnswerNo;
	}
}
