package org.poo.cb.comenzi;

import org.poo.cb.Banca;
import org.poo.cb.Cont;
import org.poo.cb.User;

import java.util.ArrayList;

public class AddAccountComanda extends Comanda {
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

		for (Cont c : user.getConturi()) {
			if (c.getTipValuta()
					.equals(parts[3])) {
				System.out.println("Account in currency " + parts[3] + " already exists for user");
				return;
			}
		}

		Cont cont = new Cont(parts[3], 0);
		user.getConturi()
				.add(cont);
	}
}
