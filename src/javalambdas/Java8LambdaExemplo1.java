package javalambdas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Java8LambdaExemplo1 {
	
	public static void main(String[] args) {
		
		JButton button1 = new JButton();
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Olá Mundo!");
			}
		});
		
		JButton button2 = new JButton(); // tecla de atalho CTRL + 1
		button2.addActionListener(e -> System.out.println("Olá Mundo!"));
		
	}
	
}
