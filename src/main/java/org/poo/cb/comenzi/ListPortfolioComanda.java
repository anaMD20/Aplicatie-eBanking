package org.poo.cb.comenzi;

import org.poo.cb.Banca;
import org.poo.cb.User;

import java.util.ArrayList;

public class ListPortfolioComanda extends Comanda {
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

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"stocks\":[");
		for (int i = 0; i < user.getActiuni()
				.size(); i++) {
			sb.append("{");
			sb.append("\"stockname\":\"")
					.append(user.getActiuni()
							.get(i)
							.getNumeCompanie())
					.append("\",");
			sb.append("\"amount\":")
					.append(user.getActiuni()
							.get(i)
							.getNumarActiuni())
					.append("}");
			if (i != user.getActiuni()
					.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("],");
		sb.append("\"accounts\":[");
		for (int i = 0; i < user.getConturi()
				.size(); i++) {
			sb.append("{");
			sb.append("\"currencyname\":\"")
					.append(user.getConturi()
							.get(i)
							.getTipValuta())
					.append("\",");
			sb.append("\"amount\":\"")
					.append(String.format("%.2f", user.getConturi()
							.get(i)
							.getSuma()))
					.append("\"}");
			if (i != user.getConturi()
					.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("]}");
		System.out.println(sb);
	}
}
