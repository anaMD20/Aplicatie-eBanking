package org.poo.cb.comenzi;

import java.util.ArrayList;

public abstract class Comanda {
	public abstract void executa(String[] parts, ArrayList<String> exchangeRates, ArrayList<String> stockValues);
}
