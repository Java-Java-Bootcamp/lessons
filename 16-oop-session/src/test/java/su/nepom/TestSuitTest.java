package su.nepom;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TestSuitTest {
	private static class StubUI implements UserInterface {
		String history = "";
		int[] results;
		int currentResult;

		@Override
		public void showQuestion(Question question) {
			history += "showQuestion: " + question.getText() + "; ";
		}

		@Override
		public int queryAnswer() {
			history += "queryAnswer; ";
			return results[currentResult++];
		}

		@Override
		public void showResults(int valid, int invalid) {
			history += "showResults: " + valid + ", " + invalid + "; ";
		}
	}

	@Test
	void run() {
		int[] results = {2, 1};
		var ui = new StubUI();
		ui.results = results;

		Question[] questionList = {
				new Question("q1",
						new String[]{"зеленый", "красный", "желтый"}, 1),
				new Question("q2",
						new String[]{"машину слева", "машину справа"}, 2)};
		var ts = new TestSuit(questionList, ui);

		ts.run();

		assertEquals("showQuestion: q1; queryAnswer; showQuestion: q2; queryAnswer; showResults: 0, 2; ", ui.history);

	}

}