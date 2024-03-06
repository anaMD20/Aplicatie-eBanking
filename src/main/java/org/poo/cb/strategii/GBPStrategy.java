package org.poo.cb.strategii;

import java.util.ArrayList;

public class GBPStrategy implements Strategy {
	@Override
	public double getExchangeRate(String currency, ArrayList<String> exchangeRates) {
		int index = 0;
		for (String s : exchangeRates.get(0)
				.split(",")) {
			if (s.equals("GBP")) {
				break;
			}
			index++;
		}

		for (String s : exchangeRates) {
			String[] split = s.split(",");
			if (split[0].equals(currency)) {
				return (Double.parseDouble(split[index]));
			}
		}

		return 0;
	}
}
