package javalambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Java8BuiltinFunctionalInterfaces {
	
	public static void main(String[] args) {
		
		// supplier - não recebe nada e retorna um valor.
		// consumer - recebe um valor e não retorna nada.
		
		Stream.generate(() -> new Random().nextInt()).limit(5) // supplier
				.forEach((e) -> System.out.println(e)); // consumer
		
		// predicate - recebe valor e retorna booleano, ex. comparação.
		// function - recebe um valor e retorna outro.
		// BinaryOperator - recebe dois valores e retorna dois de mesmo tipo.
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.stream()
			.filter(n -> n % 2 == 0) // predicate
			.map(e -> e.doubleValue()) // function
			.reduce((e1, e2) -> e1 + e2) // BinaryOperator
			.ifPresent(System.out::println); //
	}
	
}
