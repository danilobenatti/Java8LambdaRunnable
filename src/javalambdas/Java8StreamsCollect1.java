package javalambdas;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Java8StreamsCollect1 {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("Ex.1: " + list);
		
		// fornecedor - acumulação - combinação
		List<Integer> collect1 = list.stream().collect(() -> new ArrayList<>(),
				(l, e) -> l.add(e), (l1, l2) -> l1.addAll(l2));
		System.out.println("Ex.2: " + collect1);
		
		Set<Object> set1 = list.stream().collect(() -> new HashSet<>(),
				(l, e) -> l.add(e), (l1, l2) -> l1.addAll(l2));
		System.out.println("Ex.3: " + set1);
		
		Set<Object> set2 = list.stream().collect(() -> new HashSet<>(),
				(l, e) -> l.add(e.toString()), (l1, l2) -> l1.addAll(l2));
		System.out.println("Ex.4: " + set2);
		
		// toList, toSet, toCollection
		List<Integer> collect2 = list.stream().filter(n -> n % 2 == 0)
				.distinct()
				.collect(Collectors.toCollection(() -> new ArrayList<>()));
		System.out.println("Ex.5: " + collect2);
		
		Set<Integer> collect3 = list.stream().filter(n -> n % 2 == 0)
				.collect(Collectors.toSet());
		System.out.println("Ex.6: " + collect3);
		
		Set<Integer> collect4 = list.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
		System.out.println("Ex.7: " + collect4);
		
		List<Integer> collect5 = list.stream()
				.collect(Collectors.toCollection(() -> new LinkedList<>()));
		System.out.println("Ex.8: " + collect5);
		
		Deque<Integer> collect6 = list.stream()
				.collect(Collectors.toCollection(() -> new ArrayDeque<>()));
		System.out.println("Ex.9: " + collect6);
		
		// joining
		String collect7 = list.stream().map(n -> n.toString())
				.collect(Collectors.joining(","));
		System.out.println("Ex.10: " + collect7);
		
		// averaging
		Double average = list.stream()
				.collect(Collectors.averagingInt(v -> v.intValue()));
		System.out.println("média: " + average);
		
		// summing
		Integer sum = list.stream()
				.collect(Collectors.summingInt(v -> v.intValue()));
		System.out.println("soma: " + sum);
		
		// counting
		Long count = list.stream().collect(Collectors.counting());
		System.out.println("quantidade: " + count);
		
		// max
		Optional<Integer> max1 = list.stream()
				.collect(Collectors.maxBy((n1, n2) -> n1.compareTo(n2)));
		System.out.println("maior: " + max1);
		
		// min
		Optional<Integer> min1 = list.stream()
				.collect(Collectors.minBy((n1, n2) -> n1.compareTo(n2)));
		System.out.println("menor: " + min1);
		
		// max
		list.stream().filter(n -> n % 2 != 0)
				.collect(Collectors.maxBy(Comparator.naturalOrder()))
				.ifPresent(System.out::println);
		// min
		list.stream().filter(n -> n % 2 != 0)
				.collect(Collectors.minBy(Comparator.naturalOrder()))
				.ifPresent(System.out::println);
		
		// summarizing
		IntSummaryStatistics summaryStatistics = list.stream()
				.collect(Collectors.summarizingInt(v -> v.intValue()));
		System.out.println(summaryStatistics);
		System.out.println(summaryStatistics.getCount());
		System.out.println(summaryStatistics.getSum());
		System.out.println(summaryStatistics.getMin());
		System.out.println(summaryStatistics.getMax());
		System.out.println(summaryStatistics.getAverage());
		
		// groupingBy
		Map<Integer, List<Integer>> groupingBy = list.stream()
				.collect(Collectors.groupingBy(n -> n % 3));
		System.out.println(groupingBy);
		
		// partitioningBy
		Map<Boolean, List<Integer>> partitioningBy = list.stream()
				.collect(Collectors.partitioningBy(n -> n % 3 == 0));
		System.out.println(partitioningBy);
		
		// toMap
		Map<Integer, Double> toMap = list.stream().collect(
				Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 3)));
		System.out.println(toMap);
		
	}
	
}
