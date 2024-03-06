package org.poo.cb.comenzi;

public class ComandaFactory {
	public static Comanda getComanda(String numeComanda) {
		switch (numeComanda) {
			case "CREATE USER":
				return new CreateUserComanda();
			case "ADD FRIEND":
				return new AddFriendComanda();
			case "LIST USER":
				return new ListUserComanda();
			case "ADD ACCOUNT":
				return new AddAccountComanda();
			case "ADD MONEY":
				return new AddMoneyComanda();
			case "LIST PORTFOLIO":
				return new ListPortfolioComanda();
			case "EXCHANGE MONEY":
				return new ExchangeMoneyComanda();
			case "TRANSFER MONEY":
				return new TransferMoneyComanda();
			case "BUY STOCKS":
				return new BuyStocksComanda();
			case "RECOMMEND STOCKS":
				return new RecommendStocksComanda();
			default:
				return null;
		}
	}
}
