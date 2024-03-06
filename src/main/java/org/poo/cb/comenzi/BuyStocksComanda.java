package org.poo.cb.comenzi;

import org.poo.cb.Actiuni;
import org.poo.cb.Banca;
import org.poo.cb.Cont;
import org.poo.cb.User;

import java.util.ArrayList;

public class BuyStocksComanda extends Comanda {
	@Override
	public void executa(String[] parts, ArrayList<String> exchangeRates, ArrayList<String> stockValues) {
		User user = null;
		for (User u : Banca.banca.getUsers()) {
			if (u.getEmail()
					.equals(parts[2])) {
				user = u;
				break;
			}
		}

		if (user == null) {
			System.out.println("User with " + parts[2] + " doesn't exist");
		}

		Actiuni actiune = null;
		for (Actiuni a : user.getActiuni()) {
			if (a.getNumeCompanie()
					.equals(parts[3])) {
				actiune = a;
				break;
			}
		}
		if (actiune == null) {
			actiune = new Actiuni(parts[3], 0);
			user.getActiuni()
					.add(actiune);
		}

		actiune.setNumarActiuni(actiune.getNumarActiuni() + Integer.parseInt(parts[4]));

		Cont cont = null;
		for (Cont c : user.getConturi()) {
			if (c.getTipValuta()
					.equals("USD")) {
				cont = c;
				break;
			}
		}

		double valoareActiune = 0;
		for (String s : stockValues) {
			String[] stockValue = s.split(",");
			if (stockValue[0].equals(parts[3])) {
				valoareActiune = Double.parseDouble(stockValue[stockValue.length - 1]);
				break;
			}
		}

		if (cont.getSuma() < valoareActiune * Integer.parseInt(parts[4])) {
			System.out.println("Insufficient amount in account for buying stock");
			return;
		}

		cont.setSuma(cont.getSuma() - valoareActiune * Integer.parseInt(parts[4]));
	}
}
