package org.poo.cb.comenzi;

import org.poo.cb.Banca;
import org.poo.cb.Cont;
import org.poo.cb.User;

import java.util.ArrayList;

public class TransferMoneyComanda extends Comanda {
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

		Cont contUser = null;
		Cont contFriend = null;
		for (Cont c : user.getConturi()) {
			if (c.getTipValuta()
					.equals(parts[4])) {
				contUser = c;
				break;
			}
		}
		for (Cont c : friend.getConturi()) {
			if (c.getTipValuta()
					.equals(parts[4])) {
				contFriend = c;
				break;
			}
		}

		if (contUser.getSuma() < Double.parseDouble(parts[5])) {
			System.out.println("Insufficient amount in account " + parts[4] + " for transfer");
			return;
		}

		if (!user.getPrieteni()
				.contains(friend.getEmail())) {
			System.out.println("You are not allowed to transfer money to " + parts[3]);
			return;
		}

		contUser.setSuma(contUser.getSuma() - Double.parseDouble(parts[5]));
		contFriend.setSuma(contFriend.getSuma() + Double.parseDouble(parts[5]));
	}
}
