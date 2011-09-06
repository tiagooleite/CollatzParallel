package collatz.util;

public class CollatzConjectureChecker implements Runnable {
	
	private final int from;
	private final int to;
	private final int steps;

	public CollatzConjectureChecker(int from, int to, int steps) {
		this.from = from;
		this.to = to;
		this.steps = steps;
	}
	
	private void executeCollatz(int number) {
		int actualNumber = number;
		while (!endOfCollatzConjecture(actualNumber)) {
			if (isEven(actualNumber)) {
				actualNumber = actualNumber/2;
			} else {
				actualNumber = (3 * actualNumber) + 1;
			}
		}
	}

	private boolean isEven(int actualNumber) {
		return actualNumber % 2 == 0;
	}

	private boolean endOfCollatzConjecture(int actualNumber) {
		return actualNumber == 1;
	}
	
	private void checkCollatzNumberSequence() {
		for (int i = from; i < to; i+=steps) {
			executeCollatz(i);
		}
	}

	@Override
	public void run() {
		checkCollatzNumberSequence();
	}
}
