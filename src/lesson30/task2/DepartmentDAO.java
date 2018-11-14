package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    public static Set<Employee> financeDep=new HashSet<>();
    public static Set<Employee> developingDep=new HashSet<>();
    public static Set<Employee> salesDep=new HashSet<>();

    Department finance=new Department(DepartmentType.FINANCE,financeDep);
    Department developing=new Department(DepartmentType.DEVELOPING,developingDep);
    Department sales=new Department(DepartmentType.SALES,salesDep);

    public DepartmentDAO() {
        EmployeeDAO employeeDAO=new EmployeeDAO();
        financeDep.add(EmployeeDAO.employee1);
        financeDep.add(EmployeeDAO.employee4);
        developingDep.add(EmployeeDAO.employee2);
        developingDep.add(EmployeeDAO.employee3);
        developingDep.add(EmployeeDAO.employee5);
        developingDep.add(EmployeeDAO.employee6);
        salesDep.add(EmployeeDAO.employee7);

    }


}
