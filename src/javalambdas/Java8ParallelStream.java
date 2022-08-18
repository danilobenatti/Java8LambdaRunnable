package javalambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8ParallelStream {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20);
		
		// parallel vs parallelStream
//		list.parallelStream();
//		IntStream.range(0, 20).parallel();
		
		// forEach e forEachOrdered
		list.parallelStream().forEach(System.out::println);
		System.out.println("---#---");
		list.parallelStream().forEachOrdered(System.out::println);
		System.out.println("---#---");
		
		// findAny
		list.parallelStream().findAny().ifPresent(System.out::println);
		System.out.println("---#---");
		list.stream().findAny().ifPresent(System.out::println);
		System.out.println("---#---");
		
		// anyordered
		list.parallelStream().unordered().skip(2).limit(6)
				.forEach(System.out::println);
		System.out.println("---#---");
		
		// reduce
		// 1 + 2 + 3 + 4 == (1 + 2) + (3 + 4) = 10 - é associativa
		// 1 - 2 - 3 - 4 != (1 - 2) - (3 - 4) = -8 ! 0 - não é associativa
		list.parallelStream().reduce((n1, n2) -> n1 + n2)
				.ifPresent(System.out::println);
		System.out.println("---#---");
		
		// toMap e toConcurrentMap
		Map<Integer, Boolean> collect = list.parallelStream()
				.collect(Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0));
		System.out.println(collect);
		System.out.println("---#---");
		
		// groupingBy e groupingByConcurrent
		Map<Boolean, List<Integer>> collect2 = list.parallelStream()
				.collect(Collectors.groupingByConcurrent(n -> n % 2 == 0));
		System.out.println(collect2);
		System.out.println("---#---");
		
	}
	
}
