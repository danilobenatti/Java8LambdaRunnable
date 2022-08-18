package javalambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Java8Collections {
	
	public static void main(String[] args) {
		
		// Exemplos com List
		List<Double> list = new ArrayList<>();
		list.add(1.0);
		list.add(2.0);
		list.add(3.0);
		list.add(4.0);
		
		// forEach
		list.forEach(n -> System.out.println(n));
		
		// removeIf
		list.removeIf(n -> n % 2 != 0);
		for (Double integer : list) {
			System.out.println(integer);
		}
		list.forEach(System.out::println);
		
		// replaceAllS
		list.replaceAll(n -> Math.pow(n, 2));
		list.forEach(System.out::println);
		
		// Exemplos com Map
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "Teste");
		map.put(1, "teste");
		map.put(2, "Teste");
		map.put(3, "teste");
		
		// foreach
		map.forEach((k, v) -> System.out.println(k + v));
		
		// compute
		Integer key = 1;
		BiFunction<Integer, String, String> rmpfct1 = (k, v) -> v + " novo";
		map.compute(key, rmpfct1);
		map.forEach((k, v) -> System.out.println(k + v));
		
		// merge
		Integer key2 = 3;
		String value2 = " mais uma alteração";
//		BiFunction<String, String, String> rmpfct2 = (v1, v2) -> v1 + v2;
		BinaryOperator<String> rmpfct2 = (v1, v2) -> v1 + v2;
		map.merge(key2, value2, rmpfct2);
		map.forEach((k, v) -> System.out.println(k + v));
		
		// replaceAll
		map.replaceAll((k, v) -> v + "!!!");
		map.forEach((k, v) -> System.out.println(k + v));
	}
	
}
