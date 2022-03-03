package su.nepom;

import java.util.Arrays;
import java.util.List;

public class Application {
	public static void main(String ... args) {
		var ui = new ConsoleUserInterface();
		Question[] questionList = {
				new Question("На какой сигнал светофора можно ехать",
						new String[]{"зеленый", "красный", "желтый"}, 1),
				new Question("На нерегулируемом перекрестке надо пропустить",
						new String[]{"машину слева", "машину справа"}, 2)};

		var suit = new TestSuit(questionList, ui);

		suit.run();
	}

}
