package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    public  Set<Employee> financeDep=new HashSet<>();
    public  Set<Employee> developingDep=new HashSet<>();
    public  Set<Employee> salesDep=new HashSet<>();


    public Department finance=new Department(DepartmentType.FINANCE,financeDep);
    public Department developing=new Department(DepartmentType.DEVELOPING,developingDep);
    public Department sales=new Department(DepartmentType.SALES,salesDep);

    public DepartmentDAO() {
         EmployeeDAO employeeDAO=new EmployeeDAO();
        financeDep.add(employeeDAO.employee1);
        financeDep.add(employeeDAO.employee4);
        developingDep.add(employeeDAO.employee2);
        developingDep.add(employeeDAO.employee3);
        developingDep.add(employeeDAO.employee5);
        developingDep.add(employeeDAO.employee6);
        salesDep.add(employeeDAO.employee7);

    }


}
