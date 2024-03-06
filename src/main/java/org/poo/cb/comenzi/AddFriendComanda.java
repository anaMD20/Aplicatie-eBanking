package org.poo.cb.comenzi;

import org.poo.cb.Banca;
import org.poo.cb.User;

import java.util.ArrayList;

public class AddFriendComanda extends Comanda {
	@Override
	public void executa(String[] parts, ArrayList<String> exchangeRates, ArrayList<String> stockValues) {
		User user = null;
		User friend = null;
		for (User u : Banca.banca.getUsers()) {
			if (u.getEmail()
					.equals(parts[2])) {
				user = u;
			}

			if (u.getEmail()
					.equals(parts[3])) {
				friend = u;
			}
		}

		if (user == null) {
			System.out.println("User with " + parts[2] + " doesn't exist");
			return;
		}

		if (friend == null) {
			System.out.println("User with " + parts[3] + " doesn't exist");
			return;
		}

		if (user.getPrieteni()
				.contains(friend.getEmail())) {
			System.out.println("User with " + parts[3] + " is already a friend");
			return;
		}

		user.getPrieteni()
				.add(friend.getEmail());
		friend.getPrieteni()
				.add(user.getEmail());
	}
}
