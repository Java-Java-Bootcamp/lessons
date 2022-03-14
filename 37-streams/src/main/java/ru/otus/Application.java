package ru.otus;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

	public static Optional<Worker> getFirstWorkerOlder25(List<Worker> workers) {
		return workers.stream()
				.filter(w -> w.getAge() > 25)
				.findFirst();
	}

	public static Map<Sex, Long> getMaleAndFemaleCount(List<Worker> workers) {
		return workers.stream()
				.collect(Collectors.groupingBy(Worker::getSex, Collectors.counting()));
	}

	public static Map<String, List<Worker>> groupByTowns(List<Worker> workers) {
		return workers.stream()
				.collect(Collectors.groupingBy(Worker::getWorkTown));
	}

	public static List<String> workersInfo(List<Worker> workers) {
		return workers.stream()
				.map(it -> String.format("%s, %s, %s, %s",
						it.getSurname().toUpperCase(),
						it.getName().toUpperCase(),
						it.getAge(),
						it.getWorkTown()))
				.toList();
	}

	public static List<Worker> getWorkersRetire(List<Worker> workers, int yearsToRetire) {
		return workers.stream()
				.filter(w -> w.getAge() >= yearsToRetire)
				.toList();
	}

	public static void main(String[] args) {
		var w = new Worker("Ivan", "Ivanov", Sex.MALE, 10, "", "");
		System.out.println(w);
	}
}
