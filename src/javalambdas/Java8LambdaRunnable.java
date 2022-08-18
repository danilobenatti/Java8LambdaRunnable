package javalambdas;

public class Java8LambdaRunnable {
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Olá Mundo!");
			}
		}).run();
		
		new Thread(() -> System.out.println("Olá Mundo!")).run();
		
		// SAM - Single Abstract Method
		// Qualquer interface que tenha um método abstrato.
		
	}
	
}
