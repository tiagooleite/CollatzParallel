package collatz.util;

public class CollatzConjectureChecker implements Runnable {
	
	private final long from;
	private final long to;
	private final int steps;

	public CollatzConjectureChecker(long from, long to, int steps) {
		this.from = from;
		this.to = to;
		this.steps = steps;
	}
	
	private void executeCollatz(long number) {
		long actualNumber = number;
		while (!endOfCollatzConjecture(actualNumber)) {
			if (isEven(actualNumber)) {
				actualNumber = actualNumber/2;
			} else {
				actualNumber = (3 * actualNumber) + 1;
			}
		}
	}

	private boolean isEven(long actualNumber) {
		return actualNumber % 2 == 0;
	}

	private boolean endOfCollatzConjecture(long actualNumber) {
		return actualNumber == 1;
	}
	
	private void checkCollatzNumberSequence() {
		for (long i = from; i < to; i+=steps) {
			executeCollatz(i);
		}
	}

	@Override
	public void run() {
		checkCollatzNumberSequence();
	}
}
