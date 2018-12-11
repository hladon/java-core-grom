package lesson30.task2;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static java.util.Arrays.asList;

public class DepartmentDAO {

    private static List<Employee> financeDep = asList(EmployeeDAO.getEmployee1(), EmployeeDAO.getEmployee4());
    private static List<Employee> developingDep = asList(EmployeeDAO.getEmployee2(), EmployeeDAO.getEmployee3(), EmployeeDAO.getEmployee5(), EmployeeDAO.getEmployee6());
    private static List<Employee> salesDep = asList(EmployeeDAO.getEmployee7());

    private static Department finance = new Department(DepartmentType.FINANCE, financeDep);
    private static Department developing = new Department(DepartmentType.DEVELOPING, developingDep);
    private static Department sales = new Department(DepartmentType.SALES, salesDep);

    private static List<Department> department = asList(finance, developing, sales);

    public static Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        Set<Employee> employees = new HashSet<>();
        List<Employee> departmentEmployee = null;
        for (Department dep : department)
            if (dep.getType().equals(departmentType)) {
                departmentEmployee = (List<Employee>) dep.getEmployees();
                for (Employee emp : departmentEmployee) {
                    if (emp != null && emp.getProjects().isEmpty()) {
                        employees.add(emp);
                    }

                }
                return employees;
            }

        return employees;

    }

    public static List<Employee> getFinanceDep() {
        return financeDep;
    }

    public static List<Employee> getDevelopingDep() {
        return developingDep;
    }

    public static List<Employee> getSalesDep() {
        return salesDep;
    }

    public static Department getFinance() {
        return finance;
    }

    public static Department getDeveloping() {
        return developing;
    }

    public static Department getSales() {
        return sales;
    }

    public static List<Department> getDepartment() {
        return department;
    }
}
