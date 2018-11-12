package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    public static Set<Customer> customers=new HashSet<>();

    Department cust1=new Department(DepartmentType.DEVELOPING,new HashSet());
    Customer cust2=new Customer("cast2","China",2100);
    Customer cust3=new Customer("cast3","China",2200);
    Customer cust4=new Customer("cast4","China",2300);
    Customer cust5=new Customer("cast5","China",2400);
    {
        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
        customers.add(cust5);

    }
}
