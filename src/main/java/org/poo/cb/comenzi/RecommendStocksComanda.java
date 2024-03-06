package org.poo.cb.comenzi;

import java.util.ArrayList;

public class RecommendStocksComanda extends Comanda {
	@Override
	public void executa(String[] args, ArrayList<String> exchangeRates, ArrayList<String> stockValues) {
		ArrayList<String> actiuniRecomandate = new ArrayList<>();

		boolean skipHeader = true;
		for (String s : stockValues) {
			String[] stockValue = s.split(",");

			if (skipHeader) {
				skipHeader = false;
				continue;
			}

			double scurtSMA = 0;
			for (int i = stockValue.length - 1; i > stockValue.length - 6; i--) {
				scurtSMA += Double.parseDouble(stockValue[i]);
			}
			double lungSMA = scurtSMA;
			for (int i = stockValue.length - 6; i > stockValue.length - 11; i--) {
				lungSMA += Double.parseDouble(stockValue[i]);
			}


			scurtSMA /= 5;
			lungSMA /= 10;

			if (scurtSMA > lungSMA) {
				actiuniRecomandate.add(stockValue[0]);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"stockstobuy\":[");
		for (String s : actiuniRecomandate) {
			sb.append("\"");
			sb.append(s);
			sb.append("\"");
			if (actiuniRecomandate.indexOf(s) != actiuniRecomandate.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("]}");
		System.out.println(sb);
	}
}
