package ru.otus;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
	private static Worker age(String name, int age) {
		return new Worker(name, "~", Sex.MALE, age, "?", "moscow");
	}

	@Test
	void getYoungWorkers() {
		assertThat(Application.getYoungWorkers(List.of(
				age("x", 42),
				age("y", 22),
				age("z", 30),
				age("m", 18)
		))).map(Worker::getName).containsExactly("y", "m");

		assertThat(Application.getYoungWorkers(List.of(
				age("x", 42),
				age("y", 62)
		))).isEmpty();
	}

}