package collatz.util;

import java.util.ArrayList;
import java.util.List;

import collatz.objects.Pair;


public class CollatzConjectureSimulationsGenerator {

	private final int numberOfSimulations;
	private final int beginValue;
	private final int endValue;
	private final static int GROWTH_RATE = 10;
	private CollatzConjectureTimeExecutionCalculator collatzConjectureTimeExecutionCalculator;
	
	public CollatzConjectureSimulationsGenerator(int numberOfThreads,
			int numberOfSimulations, int initialRangeDynamicNumber,
			int endRangeDynamicNumber ) {
		
		this.collatzConjectureTimeExecutionCalculator = 
				new CollatzConjectureTimeExecutionCalculator(numberOfThreads);
		this.numberOfSimulations = numberOfSimulations;
		this.beginValue = initialRangeDynamicNumber;
		this.endValue = endRangeDynamicNumber;
	}
	
	public List<Pair> calculateAverages() throws InterruptedException {
		
		int begin = beginValue;
		
		List<Pair> pairs = new ArrayList<Pair>();
		
		while(begin <= endValue) {
			long sum = 0;
			for (int i = 0; i < numberOfSimulations; i++) {
				sum += collatzConjectureTimeExecutionCalculator.
						calculateExecutionTime(1, begin);
			}
			
			long average = sum/numberOfSimulations;
			Pair pair = new Pair(begin, average);
			pairs.add(pair);
			
			begin = incrementCounter(begin);
		}
		return pairs;
	}

	private int incrementCounter(int begin) {
		return begin * GROWTH_RATE;
	}
}
