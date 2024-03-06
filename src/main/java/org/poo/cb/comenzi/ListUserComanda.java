package org.poo.cb.comenzi;

import org.poo.cb.User;

import java.util.ArrayList;

public class ListUserComanda extends Comanda {
	@Override
	public void executa(String[] parts, ArrayList<String> exchangeRates, ArrayList<String> stockValues) {
		User user = null;
		for (User u : org.poo.cb.Banca.banca.getUsers()) {
			if (u.getEmail()
					.equals(parts[2])) {
				user = u;
				break;
			}
		}

		if (user == null) {
			System.out.println("User with " + parts[2] + " doesn't exist");
		}

		System.out.println(user);
	}
}
