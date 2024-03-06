package org.poo.cb;

public class Main {
	public static void main(String[] args) {
		if (args == null) {
			System.out.println("Running Main");
			return;
		}

		Banca.getInstance()
				.run(args);
	}
}
