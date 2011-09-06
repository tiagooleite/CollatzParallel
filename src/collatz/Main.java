package collatz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import collatz.objects.Pair;
import collatz.util.CollatzConjectureSimulationsGenerator;


public class Main {
	
	private static final String FILE_EXTENSION = ".txt";
	private static final String FILE_BASE_NAME = "outputNumberOfThreads-";
	private static final int NUMBER_OF_STEPS = 10;

	public static void main(String[] args) throws InterruptedException, IOException {
		int numberOfThreads = Integer.valueOf(args[0]);
		int numberOfRepetitions = Integer.valueOf(args[1]);
		int maxSerieSize = Integer.valueOf(args[2]);
		
		for (int i = 0; i < numberOfThreads; i++) {
			int numberOfCores = (int) Math.pow(2, i);
			
			CollatzConjectureSimulationsGenerator collatzConjecturesimulator = 
				new CollatzConjectureSimulationsGenerator(numberOfCores,
						numberOfRepetitions, NUMBER_OF_STEPS, maxSerieSize);
			
			List<Pair> pairs = collatzConjecturesimulator.calculateAverages();
			String fileName = FILE_BASE_NAME + numberOfCores + FILE_EXTENSION;
			saveAveragesOnFile(pairs, fileName);
		}
	}
	
	public static void saveAveragesOnFile(List<Pair> pairs, String fileName) throws IOException{
		File file = new File(fileName);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		for (Pair pair : pairs) {
			fileOutputStream.write((pair.toString() + "\n").getBytes());
		}
		
		fileOutputStream.close();
	}

}
