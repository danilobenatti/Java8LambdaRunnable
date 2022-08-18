package javalambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Java8LambdaStream {
	
	public static void main(String[] args) {
		
		// Java 8 Funções Lambdas
		
		// API Stream
		
		// stream - fluxo de dados
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		int i = 0;
		for (Integer number : list) {
			System.out.print(number + " ");
			if (i++ == list.size() - 1)
				System.out.printf("fim%n");
		}
		
		// antes de Java 8 usando o stream com funções anônimas
		list.stream().filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer e) {
				return e % 2 == 0;
			}
		}).forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer e) {
				System.out.print(e + " ");
			}
		});
		
		// a partir Java 8 usando o stream com lambdas
		list.stream().filter(e -> e % 2 == 0)
				.forEach(e -> System.out.print(e + " "));
		
	}
	
}
