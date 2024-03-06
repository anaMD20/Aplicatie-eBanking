package org.poo.cb;

import java.util.ArrayList;

public class User {
	private final String email;
	private final String nume;
	private final String prenume;
	private final String adresa;
	private final ArrayList<Actiuni> actiuni;
	private final ArrayList<Cont> conturi;
	private final ArrayList<String> prieteni;

	public User(UserBuilder builder) {
		this.email = builder.email;
		this.nume = builder.nume;
		this.prenume = builder.prenume;
		this.adresa = builder.adresa;
		this.actiuni = builder.actiuni;
		this.conturi = builder.conturi;
		this.prieteni = builder.prieteni;
	}

	public String getEmail() {
		return this.email;
	}

	public String getNume() {
		return this.nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public ArrayList<Actiuni> getActiuni() {
		return this.actiuni;
	}

	public ArrayList<Cont> getConturi() {
		return this.conturi;
	}

	public ArrayList<String> getPrieteni() {
		return this.prieteni;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"email\":\"")
				.append(this.email)
				.append("\",");
		sb.append("\"firstname\":\"")
				.append(this.nume)
				.append("\",");
		sb.append("\"lastname\":\"")
				.append(this.prenume)
				.append("\",");
		sb.append("\"address\":\"")
				.append(this.adresa)
				.append("\",");
		sb.append("\"friends\":[");
		for (int i = 0; i < this.prieteni.size(); i++) {
			sb.append("\"")
					.append(this.prieteni.get(i))
					.append("\"");
			if (i != this.prieteni.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("]}");
		return sb.toString();
	}

	public static class UserBuilder {
		private String email;
		private String nume;
		private String prenume;
		private String adresa;
		private ArrayList<Actiuni> actiuni;
		private ArrayList<Cont> conturi;
		private ArrayList<String> prieteni;

		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder setNume(String nume) {
			this.nume = nume;
			return this;
		}

		public UserBuilder setPrenume(String prenume) {
			this.prenume = prenume;
			return this;
		}

		public UserBuilder setAdresa(String adresa) {
			this.adresa = adresa;
			return this;
		}

		public UserBuilder setActiuni(ArrayList<Actiuni> actiuni) {
			this.actiuni = actiuni;
			return this;
		}

		public UserBuilder setConturi(ArrayList<Cont> conturi) {
			this.conturi = conturi;
			return this;
		}

		public UserBuilder setPrieteni(ArrayList<String> prieteni) {
			this.prieteni = prieteni;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
