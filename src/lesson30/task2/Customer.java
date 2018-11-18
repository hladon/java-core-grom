package lesson30.task2;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String name;
    private String country;
    private int monthlyPay;

    public Customer(String name, String country, int monthlyPay) {
        this.name = name;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return monthlyPay == customer.monthlyPay &&
                Objects.equals(name, customer.name) &&
                Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, monthlyPay);
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
