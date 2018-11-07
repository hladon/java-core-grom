package lesson12;

public class Main {

	public static void main(String[] args) {
		Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
		Bank usBank = new USBank(1223, "USA", Currency.USD, 101, 1500, 4, 444343465);
		Bank chinaBank = new ChinaBank(1224, "USA", Currency.USD, 102, 1600, 4, 456643465);
		User user1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);
		User user2 = new User(1002, "Robert", 12100, 30, "GMD", 1500, euBank);
		User user3 = new User(2001, "Kiril", 200, 10, "KFC", 1000, usBank);
		User user4 = new User(2002, "Sergey", 1200, 15, "KFC", 1100, usBank);
		User user5 = new User(3001, "Oleg", 6000, 30, "IBM", 700, chinaBank);
		User user6 = new User(3002, "Stas", 6300, 30, "IBM", 700, chinaBank);

		BankSystem bankSystem = new UkrainianBankSystem();

		bankSystem.withdraw(user1, 150);
		bankSystem.withdraw(user2, 150);
		bankSystem.withdraw(user3, 150);
		bankSystem.withdraw(user4, 150);
		bankSystem.withdraw(user5, 150);
		bankSystem.withdraw(user6, 150);

		bankSystem.fund(user1, 350);
		bankSystem.fund(user2, 350);
		bankSystem.fund(user3, 350);
		bankSystem.fund(user4, 350);
		bankSystem.fund(user5, 350);
		bankSystem.fund(user6, 350);

		bankSystem.transferMoney(user1, user2, 100);
		bankSystem.transferMoney(user2, user1, 100);
		bankSystem.transferMoney(user3, user2, 100);
		bankSystem.transferMoney(user4, user2, 100);
		bankSystem.transferMoney(user5, user2, 100);
		bankSystem.transferMoney(user6, user2, 100);

		bankSystem.paySalary(user1);
		bankSystem.paySalary(user2);
		bankSystem.paySalary(user3);
		bankSystem.paySalary(user4);
		bankSystem.paySalary(user5);
		bankSystem.paySalary(user6);

		System.out.println(user1.toString());
		System.out.println(user2.toString());
		System.out.println(user3.toString());
		System.out.println(user4.toString());
		System.out.println(user5.toString());
		System.out.println(user6.toString());
	}

}