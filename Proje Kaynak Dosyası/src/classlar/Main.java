package classlar;

import javax.swing.*;

public class Main {
	static JFrame pvspekran;
	static JFrame frame;
	static JFrame cvscekran;
	static menu oyunMenusu;

	public static void main(String[] args) {
		oyunMenusu = new menu();
		pvspekran = new JFrame("Player vs Computer");
		frame = new JFrame("Kart Oyunu");
		cvscekran = new JFrame("Computer vs Computer");

		frame.setSize(800,600);
		frame.add(oyunMenusu);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		pvspekran.setSize(800, 600);
		pvspekran.setLocationRelativeTo(null);
		pvspekran.setResizable(false);
		pvspekran.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pvspekran.setVisible(false);

		cvscekran.setSize(800, 600);
		cvscekran.setLocationRelativeTo(null);
		cvscekran.setResizable(false);
		cvscekran.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cvscekran.setVisible(false);


	}

}
