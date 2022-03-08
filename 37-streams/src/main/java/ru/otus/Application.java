package ru.otus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
	public static List<Worker> getYoungWorkers(List<Worker> workers) {
		return workers.stream()
				.filter(w -> w.getAge() < 30)
				.toList();
	}

	public static List<Worker> getYoungWorkersInParallel(List<Worker> workers) {
		return workers.stream()
				.parallel()
				.filter(w -> w.getAge() < 30)
				.toList();
	}

	public static Map<Sex, Integer> getMaleAndFemaleCount(List<Worker> workers) {
		return workers.stream()
				.collect(HashMap::new,
						(cnt, w) -> cnt.compute(w.getSex(),
								(ignored, cur) -> cur == null ? 1 : cur + 1),
						(a, b) -> b.forEach(
								(sex, cnt) -> a.compute(sex,
										(ignored, cur) -> cur == null ? cnt : cur + cnt))
				);
	}

	public static void main(String[] args) {

	}
}
