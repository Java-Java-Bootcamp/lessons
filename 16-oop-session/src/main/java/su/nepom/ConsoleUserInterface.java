package su.nepom;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
	@Override
	public void showQuestion(Question question) {
		System.out.println("Вопрос: " + question.getText());
		System.out.println("Варианты ответа");
		for (int i = 0; i < question.getAnswers().length; ++i) {
			System.out.println("" + (i+1) + ". " + question.getAnswers()[i]);
		}
	}

	@Override
	public int queryAnswer() {
		System.out.println("Выберите вариант ответа: ");
		return new Scanner(System.in).nextInt();
	}

	@Override
	public void showResults(int valid, int invalid) {
		System.out.println("Ваши результаты: " + valid + " правильных "
				+ invalid + " неправильных ответов");
	}
}
