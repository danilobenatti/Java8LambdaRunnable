package javalambdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamCreation {
	
	public static void main(String[] args) {
		
		// Collection
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.stream().forEach(System.out::println);
		list.parallelStream().forEach(System.out::println);
		
		// Stream
		Integer[] intArray = new Integer[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9
		};
		Arrays.stream(intArray).forEach(System.out::println);
		
		// Stream.of
		Stream.of("a", "b", "c", "d", "e").forEach(System.out::println);
		
		// IntStream.range
		IntStream.range(0, 10).forEach(System.out::println);
		
		// IntStream.rangeClosed
		IntStream.rangeClosed(15, 20).forEach(System.out::println);
		
		// Stream.iterate
		Stream.iterate(5, n -> n * 5).limit(10).forEach(System.out::println);
		
		// BufferedReader - lines / read file streams.txt
		try {
			File file = new File("./src/streams.txt");
			FileReader reader = new FileReader(file.getAbsoluteFile());
			BufferedReader bufferedReader = new BufferedReader(reader);
			bufferedReader.lines().forEach(System.out::println);
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Files
		Path path = Paths.get("");
		try {
			Files.list(path).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Random
		new Random().ints().limit(5).forEach(System.out::println);
		
		// Pattern
		String s = "Teste teste Teste teste";
		Pattern pattern = Pattern.compile(" ");
		pattern.splitAsStream(s).forEach(System.out::println);
	}
	
}
