package lesson12hw;

public class ChinaBank extends Bank {
	public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee,
			long rating, long totalCapital) {
		super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);

	}

	public int getLimitOfWithdrawal() {
		if (getCurrency() == Currency.EUR) {
			return 150;
		}
		return 100;
	}

	public int getLimitOfFunding() {
		if (getCurrency() == Currency.EUR) {
			return 5000;
		}
		return 10000;
	}

	public double getMonthlyRate() {
		if (getCurrency() == Currency.USD) {
			return 0.01;
		}
		return 0.00;
	}

	public double getCommission(int amount) {
		if (getCurrency() == Currency.USD) {
			if (amount <= 1000) {
				return 0.03;
			} else {
				return 0.05;
			}
		} else {
			if (amount <= 1000) {
				return 0.1;
			} else {
				return 0.11;
			}
		}
	}
}