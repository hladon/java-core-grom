package lesson10.lesson10hw;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		ElectronicsOrder elOrder1 = new ElectronicsOrder("Fan", new Date(), "����", "������", 200,
				new Customer("����", "������", "�������"), 12);
		ElectronicsOrder elOrder2 = new ElectronicsOrder("Water Heater", new Date(), "����", "�����", 200, null, 12);

		FurnitureOrder furOrder1 = new FurnitureOrder("Table", new Date(), "����", "������", 200,
				new Customer("����", "������", "�������"), "Black Oak");
		FurnitureOrder furOrder2 = new FurnitureOrder("Chare", new Date(), "����", "�����", 200, null, "Savoya");

		elOrder1.validateOrder();
		elOrder1.calculatePrice();
		elOrder1.confirmShipping();
		
		System.out.println(elOrder1.toString());

		elOrder2.validateOrder();
		elOrder2.calculatePrice();
		elOrder2.confirmShipping();
		
		System.out.println(elOrder2.toString());

		furOrder1.validateOrder();
		furOrder1.calculatePrice();
		furOrder1.confirmShipping();
		
		System.out.println(furOrder1.toString());

		furOrder2.validateOrder();
		furOrder2.calculatePrice();
		furOrder2.confirmShipping();
		
		System.out.println(furOrder2.toString());

	}

}
