package javalambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.DoubleStream;

public class Java8StreamsReduce {
	
	public static void main(String[] args) {
		
		List<Integer> listNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		listNum.stream().forEach(System.out::println);
		
		String str = "  A B C D E F G H I J K L M N O P Q R S T U V W X Y Z  ";
		String[] splitStr = str.trim().split(" ");
		List<String> lstStr = Arrays.asList(splitStr);
		Object[] arrayStr = lstStr.toArray();
		System.out.println(Arrays.toString(arrayStr));
		
		// reduce soma
		BinaryOperator<Integer> accumulator = (t, u) -> t + u;
		Optional<Integer> soma = listNum.stream().reduce(accumulator);
		System.out.println(soma.isPresent() ? soma.get() : null);
		
		// reduce multiplicação
		Optional<Integer> multiplica = listNum.stream().reduce((t, u) -> t * u);
		System.out.println(multiplica.isPresent() ? multiplica.get() : null);
		
		// reduce subtraçãp - NÃO RECOMENDADO ESSE TIPO DE MÉTODO COM SUBTRAÇÃO
		Optional<Integer> subtrair1 = listNum.stream().reduce((t, u) -> t - u);
		System.out.println(subtrair1.isPresent() ? subtrair1.get() : null);
		Optional<Integer> subtrair2 = listNum.stream().parallel()
				.reduce((t, u) -> t - u);
		System.out.println(subtrair2.isPresent() ? subtrair2.get() : null);
		
		// reduce concatenação 1
		Optional<String> conct1 = lstStr.stream().reduce((t, u) -> t + u);
		System.out.println(conct1.isPresent() ? conct1.get() : null);
		
		// reduce concatenação 2
		Optional<String> conct2 = lstStr.stream().reduce((t, u) -> t.concat(u));
		System.out.println(conct2.isPresent() ? conct2.get() : null);
		
		List<Integer> listNumBlank = Arrays.asList();
		List<String> lstStrBlank = Arrays.asList("A B C");
		// reduce soma - parte 2
		Integer soma2 = listNum.stream().reduce(0, (t, u) -> t + u);
		System.out.println(soma2);
		Integer soma3 = listNumBlank.stream().reduce(0, (t, u) -> t + u);
		System.out.println(soma3);
		
		// reduce multiplicação - parte 2
		Integer multiplica2 = listNum.stream().reduce(1, (t, u) -> t * u);
		System.out.println(multiplica2);
		Integer multiplica3 = listNumBlank.stream().reduce(1, (t, u) -> t * u);
		System.out.println(multiplica3);
		
		// reduce concatenação parte 2
		String conct3 = lstStr.stream().reduce("", (t, u) -> t.concat(u));
		System.out.println(conct3);
		String conct4 = lstStrBlank.stream().reduce("", (t, u) -> t.concat(u));
		System.out.println(conct4);
		
		// reduce menor valor parte 2
		// Math::min -> (d1, d2) -> Math.min(d1, d2)
		double menorValor = DoubleStream.of(1.5, 2.9, 6.7)
				.reduce(Double.POSITIVE_INFINITY, Math::min);
		System.out.println(menorValor);
		
		// reduce soma - parte 3 / função de acumulação + função de combinação
		Integer soma4 = listNum.stream().reduce(0, (t, u) -> t + u, (t, u) -> t + u);
		System.out.println(soma4);
		
		// reduce map + combine
		String reduce = listNum.stream().reduce("",
				(n1, n2) -> n1.concat(n2.toString()),
				(n1, n2) -> n1.concat(n2));
		System.out.println(reduce);
		
	}
	
}
