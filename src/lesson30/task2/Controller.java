package lesson30.task2;

import java.util.*;

public class Controller {
    EmployeeDAO employeeDAO = new EmployeeDAO();

    public static HashSet<Employee> employeesByProject(String project) {

        return EmployeeDAO.employeesByProject(project);
    }

    public static List<Project> projectsByEmployee(Employee employee) {

        return employee.getProjects();

    }

    public static Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        return DepartmentDAO.employeesByDepartmentWithoutProject(departmentType);

    }

    public static Collection<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    public static Set<Employee> employeesByTeemLead(Employee lead) {

        return EmployeeDAO.employeesByTeemLead(lead);
    }

    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public static Set<Project> projectsByCustomer(Customer customer) {
        return ProjectDAO.projectsByCustomer(customer);
    }

    public static Collection<Employee> employeesByCustomerProjects(Customer customer) {
        Set<Employee> employees = new HashSet<>();
        Collection<Project> projects = projectsByCustomer(customer);
        for (Project proj : projects) {
            employees.addAll(employeesByProject(proj.getName()));
        }

        return employees;
    }

}
