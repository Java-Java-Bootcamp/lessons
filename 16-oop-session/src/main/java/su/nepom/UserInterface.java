package su.nepom;

public interface UserInterface {
	void showQuestion(Question question);
	int queryAnswer();
	void showResults(int valid, int invalid);
}
