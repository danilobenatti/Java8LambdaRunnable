package javalambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Streams {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 25, 6, 6, 9, 9);
		
		// Java 4
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			System.out.print(integer + ":");
		}
		
		// Java 5
		for (Integer integer : list) {
			System.out.print(integer + "-");
		}
		
		// Java 8
		// stream -> fluxo de dados
		list.stream().skip(2).limit(8).distinct().sorted()
				.filter(e -> e % 2 != 0).map(e -> Math.sqrt(e))
				.forEach(e -> System.out.print(e + "*"));
		
		Stream<Double> map = list.stream().skip(2).limit(8).distinct().sorted()
				.filter(e -> e % 2 != 0).map(e -> Math.sqrt(e));
		map.forEach(e -> System.out.print(e + "/")); // operação terminal
		
		// variável "list" não é alterada
		System.out.printf("%n%s", list);
		
		long count = list.stream().filter(e -> e % 2 == 0).count();
		System.out.printf("%n%d elementos pares.", count);
		
		Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
		System.out.printf("%nO maior elementos é: %d",
				max.isPresent() ? max.get() : 0);
		
		List<Integer> collect1 = list.stream().filter(e -> e % 2 == 0)
				.map(e -> e * 3).collect(Collectors.toList());
		System.out.printf("%n%s", collect1);
		
		Map<Boolean, List<Integer>> collect2 = list.stream().map(e -> e * 3)
				.collect(Collectors.groupingBy(e -> e % 2 == 0));
		System.out.printf("%n%s", collect2);
		
		Map<Integer, List<Integer>> collect3 = list.stream()
				.collect(Collectors.groupingBy(e -> e % 3));
		System.out.printf("%n%s", collect3);
		
		String collect4 = list.stream().map(e -> String.valueOf(e))
				.collect(Collectors.joining(";"));
		System.out.printf("%n%s", collect4);
		
		// stream - loops implícetos
		// for - while - do...while - loops explícitos
	}
	
}
