package lesson30.task2;


import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class DepartmentDAO {

    public static List<Employee> financeDep=asList(EmployeeDAO.employee1,EmployeeDAO.employee4);
    public static List<Employee> developingDep=asList(EmployeeDAO.employee2,EmployeeDAO.employee3,EmployeeDAO.employee5,EmployeeDAO.employee6);
    public static List<Employee> salesDep=asList(EmployeeDAO.employee7);

    public  static Department finance=new Department(DepartmentType.FINANCE,financeDep);
    public  static Department developing=new Department(DepartmentType.DEVELOPING,developingDep);
    public  static Department sales=new Department(DepartmentType.SALES,salesDep);



}
