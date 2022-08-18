package javalambdas;

import java.util.Arrays;
import java.util.List;

public class Java8DebugLambda {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		list.stream().peek(n -> System.out.println(n + " peek here!"))
				.filter(n -> n % 2 == 0).map((n) -> convertForStringBuilder(n))
				.peek(n -> System.out.println(n + " other peek!"))
				.forEach(System.out::println);
	}
	
	private static StringBuilder convertForStringBuilder(Integer n) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(n);
		stringBuilder.append("a");
		stringBuilder.append("b");
		stringBuilder.append("c");
		return stringBuilder;
	}
	
}
