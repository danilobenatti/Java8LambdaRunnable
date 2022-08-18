package javalambdas;

import java.util.stream.IntStream;

public class Java8Lambda {
	
	public static void main(String[] args) {
		
		// Com parênteses
		// exemplo de ausência de parâmetros
		Runnable runnable = () -> System.out.println("Não passa argumento");
		runnable.run();
		
		IntStream.range(0, 10).filter(n -> n % 2 == 0)
				.forEach(System.out::println);
		
		// exemplo com tipos de variáveis
		IntStream.range(0, 10).filter((int n) -> n % 2 == 0)
				.reduce((int n1, int n2) -> n1 + n2)
				.ifPresent(System.out::println);
		
		// Com chaves e return
		IntStream.range(0, 10).filter(n -> {
			System.out.println("Algum código/processo");
			return n % 3 == 0;
		}).forEach(n -> System.out.println(n)); // expressão simples
		
	}
	
}
