package lesson30.task2;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {
    public static Set<Employee> employees=new HashSet<>();

    Employee employee1=new Employee("Derek","Smith",new Date(28/10/2011),Position.ANALYST,null,null);
    Employee employee2=new Employee("Boris","Bobko",new Date(28/10/2011),Position.DESIGNER,null,null);
    Employee employee3=new Employee("Lara","Lah",new Date(28/10/2011),Position.DEVELOPER,null,null);
    Employee employee4=new Employee("Fedir","Johns",new Date(28/10/2011),Position.FINANCE,null,null);
    Employee employee5=new Employee("Nelia","Dram",new Date(28/10/2011),Position.LEAD_DESIGNER,null,null);
    Employee employee6=new Employee("Katrin","Denef",new Date(28/10/2011),Position.MANAGER,null,null);
    Employee employee7=new Employee("Will","Smith",new Date(28/10/2011),Position.TEAM_LEAD,null,null);
    {
        employees.add( employee1);
        employees.add( employee2);
        employees.add( employee3);
        employees.add( employee4);
        employees.add( employee5);
        employees.add( employee6);
        employees.add( employee7);


    }
}
