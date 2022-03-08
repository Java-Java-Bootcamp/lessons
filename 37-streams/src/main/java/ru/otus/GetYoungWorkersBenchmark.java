package ru.otus;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
public class GetYoungWorkersBenchmark {
	@org.openjdk.jmh.annotations.State(Scope.Benchmark)
	public static class State {
		final List<Worker> workers = new ArrayList<>();

		public State() {
			var rand = new Random();
			for (int i = 0; i < 100_000_000; ++i) {
				workers.add(new Worker("x" + i, "", Sex.MALE, rand.nextInt(65-18) + 18, "", ""));
			}
		}
	}

	@Benchmark
	public void simple(Blackhole blackhole, State state) {
		blackhole.consume(Application.getYoungWorkers(state.workers));
	}

	@Benchmark
	public void parallel(Blackhole blackhole, State state) {
		blackhole.consume(Application.getYoungWorkersInParallel(state.workers));
	}

	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}
}
