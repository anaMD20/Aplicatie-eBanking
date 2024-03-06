package org.poo.cb.comenzi;

import org.poo.cb.Banca;
import org.poo.cb.Cont;
import org.poo.cb.User;
import org.poo.cb.strategii.Strategy;
import org.poo.cb.strategii.USDStrategy;

import java.util.ArrayList;

public class ExchangeMoneyComanda extends Comanda {
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

		Cont sursa = null;
		Cont destinatie = null;
		for (Cont c : user.getConturi()) {
			if (c.getTipValuta()
					.equals(parts[3])) {
				sursa = c;
			}

			if (c.getTipValuta()
					.equals(parts[4])) {
				destinatie = c;
			}
		}

		if (Double.parseDouble(parts[5]) > sursa.getSuma()) {
			System.out.println("Insufficient amount in account " + parts[3] + " for exchange");
			return;
		}

		Strategy strategy = new USDStrategy();
		double exchangeRate = strategy.getExchangeRate(parts[4], exchangeRates);

		double suma = Double.parseDouble(parts[5]) * exchangeRate;
		double comision = suma > sursa.getSuma() / 2 ? suma * 0.01 : 0;
		sursa.setSuma(sursa.getSuma() - suma - comision);
		destinatie.setSuma(destinatie.getSuma() + Double.parseDouble(parts[5]));
	}
}
