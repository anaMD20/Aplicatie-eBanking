package org.poo.cb;

public class Cont {
	private final String tipValuta;
	private double suma;

	public Cont(final String tipValuta, final double suma) {
		this.tipValuta = tipValuta;
		this.suma = suma;
	}

	public String getTipValuta() {
		return tipValuta;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}
}
