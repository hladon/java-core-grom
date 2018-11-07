package lesson12;

public class UkrainianBankSystem implements BankSystem {

	@Override
	public void withdraw(User user, int amount) {

		if (!checkWithdraw(user, amount)) {

			return;
		}

		user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
	}

	@Override
	public void fund(User user, int amount) {
		if (user != null && amount > 0 && user.getBank().getLimitOfFunding() > amount) {
			user.setBalance(user.getBalance() + amount);
		}

	}

	@Override
	public void transferMoney(User fromUser, User toUser, int amount) {
		if (!checkWithdraw(fromUser, amount)) {
			return;
		}
		if (toUser != null && amount > 0 && toUser.getBank().getLimitOfFunding() > amount
				&& toUser.getBank().getCurrency() == fromUser.getBank().getCurrency()) {
			fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));

			toUser.setBalance(toUser.getBalance() + amount);
		}

	}

	@Override
	public void paySalary(User user) {

		fund(user, user.getSalary());
	}

	private void printWithdrawalErorMsg(int amount, User user) {
		System.err.println("Can`t withdraw money " + amount + "from user " + user.toString());
	}

	private boolean checkWithdraw(User user, int amount) {
		return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal())
				&& checkWithdrawLimits(user, amount, user.getBalance());
	}

	private boolean checkWithdrawLimits(User user, int amount, double limit) {
		if (amount + user.getBank().getCommission(amount) > limit) {
			printWithdrawalErorMsg(amount, user);
			return false;
		}
		return true;
	}

}