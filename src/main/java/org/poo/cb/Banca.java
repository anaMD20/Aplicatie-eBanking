package org.poo.cb;

import org.poo.cb.comenzi.Comanda;
import org.poo.cb.comenzi.ComandaFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Banca {
	public static Banca banca = null;
	private ArrayList<User> users;

	private Banca() {
	}

	public static Banca getInstance() {
		if (banca == null) {
			banca = new Banca();
		}
		return banca;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void run(String[] args) {
		users = new ArrayList<>();

		ArrayList<String> exchangeRates = citesteDinFisier("src/main/resources/" + args[0]);
		ArrayList<String> stockValues = citesteDinFisier("src/main/resources/" + args[1]);
		ArrayList<String> comenzi = citesteDinFisier("src/main/resources/" + args[2]);

		for (String comanda : comenzi) {
			String[] parts = comanda.split(" ");
			String numeComanda = parts[0] + " " + parts[1];
			Comanda cmd = ComandaFactory.getComanda(numeComanda);
			cmd.executa(parts, exchangeRates, stockValues);
		}
	}

	private ArrayList<String> citesteDinFisier(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			ArrayList<String> lines = new ArrayList<>();

			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			return lines;
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
			return null;
		}
	}
}
