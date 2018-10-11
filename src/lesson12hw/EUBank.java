package lesson12hw;

public class EUBank extends Bank {
	public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee,
			long rating, long totalCapital) {
		super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);

	}

	public int getLimitOfWithdrawal() {
		if (getCurrency() == Currency.EUR) {
			return 2200;
		}
		return 2000;
	}

	public int getLimitOfFunding() {
		if (getCurrency() == Currency.EUR) {
			return 20000;
		}
		return 10000;
	}

	public double getMonthlyRate() {
		if (getCurrency() == Currency.EUR) {
			return 0.01;
		}
		return 0.00;
	}

	public double getCommission(int amount) {
		if (getCurrency() == Currency.USD) {
			if (amount <= 1000) {
				return 0.05;
			} else {
				return 0.07;
			}
		} else {
			if (amount <= 1000) {
				return 0.02;
			} else {
				return 0.04;
			}
		}
	}

}