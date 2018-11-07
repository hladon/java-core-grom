package lesson10.lesson10hw;

import java.util.Date;

public class ElectronicsOrder extends Order {
	private int guaranteeMonths;

	public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice,
			Customer customerOwned, int guaranteeMonths) {
		super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
		this.guaranteeMonths = guaranteeMonths;
	}

	private boolean checkingStock(String adress) {
		String[] aviable = { "����", "������", "�����", "�������" };
		for (String stock : aviable) {
			if (adress.equals(stock)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void validateOrder() {
		if (getCustomerOwned() == null) {
			return;
		}
		if (checkingStock(getShipFromCity()) && checkingStock(getShipToCity())) {

			if (getCustomerOwned().getGender().equals("�������") && getBasePrice() > 100) {
				setDateConfirmed(new Date());

			}
		}
	}

	@Override
	public void calculatePrice() {
		double commision = getShipToCity() != null
				&& (getShipToCity().equalsIgnoreCase("����") || getShipToCity().equalsIgnoreCase("������"))
						? getBasePrice() * 0.10
						: getBasePrice() * 0.15;
		double bonus = getBasePrice() > 1000 ? (getBasePrice() + commision) * 0.05 : 0;
		setTotalPrice(getBasePrice() + commision - bonus);

	}

}