package org.poo.cb.strategii;

import java.util.ArrayList;

public interface Strategy {
	double getExchangeRate(String currency, ArrayList<String> exchangeRates);
}
