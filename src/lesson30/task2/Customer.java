package lesson30.task2;

public class Customer   implements Comparable <Customer> {
    private String name;
    private String country;
    private int monthlyPay;

    public Customer(String name, String country, int monthlyPay) {
        this.name = name;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }

    @Override
    public int compareTo(Customer customer) {
        return customer.getName().compareTo(this.getName());
    }
}
