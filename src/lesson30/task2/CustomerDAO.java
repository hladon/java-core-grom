package lesson30.task2;

import java.util.*;

public class CustomerDAO {
    public static Set<Customer> customers=new HashSet<>();

    static Customer cust1=new Customer("cast1","China",2000);
    static Customer cust2=new Customer("cast2","China",2100);
    static Customer cust3=new Customer("cast3","China",2200);
    static Customer cust4=new Customer("cast4","China",2300);
    static Customer cust5=new Customer("cast5","China",2400);
    {
        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
        customers.add(cust5);

    }


}
