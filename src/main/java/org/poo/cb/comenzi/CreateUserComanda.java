package org.poo.cb.comenzi;

import org.poo.cb.Banca;
import org.poo.cb.User;

import java.util.ArrayList;

public class CreateUserComanda extends Comanda {
	@Override
	public void executa(String[] parts, ArrayList<String> exchangeRates, ArrayList<String> stockValues) {
		for (User user : Banca.getInstance()
				.getUsers()) {
			if (user.getEmail()
					.equals(parts[2])) {
				System.out.println("User with " + parts[2] + " already exists");
				return;
			}
		}

		StringBuilder address = new StringBuilder();
		for (int i = 5; i < parts.length; i++) {
			address.append(parts[i]);
			if (i != parts.length - 1) {
				address.append(" ");
			}
		}

		User user = new User.UserBuilder().setEmail(parts[2])
				.setNume(parts[3])
				.setPrenume(parts[4])
				.setAdresa(address.toString())
				.setActiuni(new ArrayList<>())
				.setConturi(new ArrayList<>())
				.setPrieteni(new ArrayList<>())
				.build();

		Banca.getInstance()
				.getUsers()
				.add(user);
	}
}
