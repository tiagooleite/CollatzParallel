package collatz.objects;

public class Pair {
	
	private static final String FILE_SEPARATOR = " : ";
	private long number;
	private long average;
	

	public Pair(long begin, long average) {
		this.number = begin;
		this.average = average;
	}
	
	@Override
	public String toString() {
		return this.number + FILE_SEPARATOR + this.average;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getAverage() {
		return average;
	}

	public void setAverage(long average) {
		this.average = average;
	}
	
	
}