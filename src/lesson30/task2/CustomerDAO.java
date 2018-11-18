package lesson30.task2;

import java.util.*;

import static java.util.Arrays.asList;

public class CustomerDAO {


    static Customer cust1 = new Customer("cast1", "China", 2000);
    static Customer cust2 = new Customer("cast2", "China", 2100);
    static Customer cust3 = new Customer("cast3", "China", 2200);
    static Customer cust4 = new Customer("cast4", "China", 2300);
    static Customer cust5 = new Customer("cast5", "China", 2400);
    public static List<Customer> customers = asList(cust1, cust2, cust3, cust4, cust5);

}
