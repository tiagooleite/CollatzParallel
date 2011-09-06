package collatz.objects;

public class Pair {
	
	private static final String FILE_SEPARATOR = " : ";
	private int number;
	private long average;
	

	public Pair(int number, long average) {
		this.number = number;
		this.average = average;
	}
	
	@Override
	public String toString() {
		return this.number + FILE_SEPARATOR + this.average;
	}
}