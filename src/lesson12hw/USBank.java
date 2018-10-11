package lesson12hw;

public class USBank extends Bank {

	public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee,
			long rating, long totalCapital) {
		super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);

	}

	public int getLimitOfWithdrawal() {
		if (getCurrency() == Currency.EUR) {
			return 1200;
		}
		return 1000;
	}

	public int getLimitOfFunding() {
		if (getCurrency() == Currency.EUR) {
			return 10000;
		}
		return Integer.MAX_VALUE;
	}

	public double getMonthlyRate() {
		if (getCurrency() == Currency.EUR) {
			return 0.02;
		}
		return 0.01;
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
				return 0.06;
			} else {
				return 0.08;
			}
		}
	}

}