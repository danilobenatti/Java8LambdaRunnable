package javalambdas;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Java8Optional {
	
	public static void main(String[] args) {
//		String s = "String";
		String s = "1";
//		System.out.println(convertForNumber1(s));
		Optional<Integer> convertForNumber2 = convertForNumber2(s);
		System.out.println(convertForNumber2);
		System.out.println(convertForNumber2.isPresent());
		if (convertForNumber2.isPresent()) {
			System.out.println(convertForNumber2.get());
		}
		convertForNumber2.ifPresent(n -> System.out.println(n));
		convertForNumber2.ifPresent(System.out::println);
		
		Integer value1 = convertForNumber2(s).orElse(0);
		System.out.println(value1);
		
		int value2 = convertForNumber3(s).orElse(0);
		System.out.println(value2);
		
		Stream.of(1, 2, 3).findFirst().ifPresent(n -> System.out.println(n));
	}
	
	public static Integer convertForNumber1(String value) {
		return Integer.valueOf(value);
	}
	
	public static Optional<Integer> convertForNumber2(String value) {
		try {
			return Optional.of(Integer.valueOf(value));
		} catch (NumberFormatException ex) {
			return Optional.empty();
		}
	}
	
	public static OptionalInt convertForNumber3(String value) {
		try {
			return OptionalInt.of(Integer.parseInt(value));
		} catch (NumberFormatException ex) {
			return OptionalInt.empty();
		}
	}
	
}
