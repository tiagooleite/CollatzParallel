package collatz.util;

import java.util.ArrayList;
import java.util.List;

public class CollatzConjectureTimeExecutionCalculator {
	private int numberOfThreads;
	
	public CollatzConjectureTimeExecutionCalculator(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}
	
	public long calculateExecutionTime(int from, int to) throws InterruptedException{
		
		long initExecutionTime = System.nanoTime();
		List<Thread> collatzConjectureCheckers = createThreads(from, to);
		
		startThreads(collatzConjectureCheckers);
		
		joinThreads(collatzConjectureCheckers);
		
		long executionTime = System.nanoTime() - initExecutionTime;
		
		return executionTime;
	}


	private void joinThreads(List<Thread> collatzConjectureCheckers)
			throws InterruptedException {
		for (Thread thread : collatzConjectureCheckers) {
			thread.join();
		}
	}

	private void startThreads(List<Thread> collatzConjectureCheckers) {
		for (Thread thread : collatzConjectureCheckers) {
			thread.start();
		}
	}

	private List<Thread> createThreads(int from, int to) {
		List<Thread> collatzConjectureCheckers = new ArrayList<Thread>();
		
		for (int i = 0; i < numberOfThreads; i++) {
			Thread collatzConjectureCheckerThread = new Thread(
					new CollatzConjectureChecker(from + i, to, numberOfThreads));
			collatzConjectureCheckers.add(collatzConjectureCheckerThread);
		}
		
		return collatzConjectureCheckers;
	}
}
