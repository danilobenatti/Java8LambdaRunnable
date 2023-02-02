package javalambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Java8ForEachListExamples {
	
	public static void main(String[] args) {
		
		List<String> items1 = new ArrayList<>();
		
		items1.addAll(Arrays.asList("coins", "pens", "keys", "sheets"));
		
		items1.forEach(new Consumer<String>() {
			@Override
			public void accept(String name) {
				System.out.println(name);
			}
		});
		
		items1.forEach((String name) -> {
			System.out.println(name);
		});
		
		items1.forEach(System.out::println);
		
		Map<Integer, String> items2 = new HashMap<>();
		
		items2.put(3, "coins");
		items2.put(2, "pens");
		items2.put(1, "keys");
		items2.put(12, "sheets");
		
		items2.forEach((k, v) -> System.out.printf("%d : %s%n", k, v));
	}
	
}
