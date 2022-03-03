package su.nepom;


import java.util.List;

public class TestSuit {
	private final Question[] questionList;
	private final UserInterface ui;
	private int countValidAnswers;

	public TestSuit(Question[] questionList, UserInterface ui) {
		this.questionList = questionList;
		this.ui = ui;
	}

	public void run() {
		for (var question : questionList) {
			ui.showQuestion(question);
			var answer = ui.queryAnswer();
			if (question.isValidAnswer(answer))
				countValidAnswers += 1;
		}
		ui.showResults(countValidAnswers, questionList.length - countValidAnswers);
	}
}
