package lesson30.task2;

import java.util.*;

import static java.util.Arrays.asList;

public class EmployeeDAO {


    private static List<Project> employee1Projecs = asList(ProjectDAO.getProject1(), ProjectDAO.getProject2(), ProjectDAO.getProject3());
    private static List<Project> employee2Projecs = asList(ProjectDAO.getProject2(), ProjectDAO.getProject3(), ProjectDAO.getProject4());
    private static List<Project> employee3Projecs = asList(ProjectDAO.getProject3(), ProjectDAO.getProject4(), ProjectDAO.getProject5());
    private static List<Project> employee4Projecs = asList(ProjectDAO.getProject4(), ProjectDAO.getProject5(), ProjectDAO.getProject1());
    private static List<Project> employee5Projecs = asList(ProjectDAO.getProject5(), ProjectDAO.getProject1(), ProjectDAO.getProject4());
    private static List<Project> employee6Projecs = asList();
    private static List<Project> employee7Projecs = asList(ProjectDAO.getProject1(), ProjectDAO.getProject2(), ProjectDAO.getProject3());

    private static Employee employee1 = new Employee("Derek", "Smith", new Date(28 / 10 / 2011), Position.ANALYST, DepartmentDAO.getFinance(), employee1Projecs);
    private static Employee employee2 = new Employee("Boris", "Bobko", new Date(28 / 10 / 2011), Position.DESIGNER, DepartmentDAO.getDeveloping(), employee2Projecs);
    private static Employee employee3 = new Employee("Lara", "Lah", new Date(28 / 10 / 2011), Position.DEVELOPER, DepartmentDAO.getDeveloping(), employee3Projecs);
    private static Employee employee4 = new Employee("Fedir", "Johns", new Date(28 / 10 / 2011), Position.FINANCE, DepartmentDAO.getFinance(), employee4Projecs);
    private static Employee employee5 = new Employee("Nelia", "Dram", new Date(28 / 10 / 2011), Position.LEAD_DESIGNER, DepartmentDAO.getDeveloping(), employee5Projecs);
    private static Employee employee6 = new Employee("Katrin", "Denef", new Date(28 / 10 / 2011), Position.MANAGER, DepartmentDAO.getSales(), employee6Projecs);
    private static Employee employee7 = new Employee("Will", "Smith", new Date(28 / 10 / 2011), Position.TEAM_LEAD, DepartmentDAO.getDeveloping(), employee7Projecs);

    private static List<Employee> employees = asList(employee1, employee3, employee2, employee4, employee5, employee6, employee7);


    public static HashSet<Employee> employeesByProject(String project) {
        Collection<Employee> workers = new HashSet<Employee>();

        for (Employee emp : employees) {
            for (Project proj : emp.getProjects()) {
                if (proj.getName().equalsIgnoreCase(project))
                    workers.add(emp);
            }
        }
        return (HashSet<Employee>) workers;
    }

    public static Set<Employee> employeesWithoutProject() {
        Set<Employee> employees = new HashSet<>();
        for (Employee emp : employees) {
            if (emp.getProjects().isEmpty()) {
                employees.add(emp);
            }
        }
        return employees;
    }

    public static Set<Employee> employeesByTeemLead(Employee lead) {

        Set<Employee> employees = new HashSet<>();
        for (Employee emp : employees) {
            for (Project proj : emp.getProjects()) {
                if (lead.getProjects().contains(proj)) {
                    employees.add(emp);
                }
            }

        }
        return employees;
    }

    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();
        for (Employee emp : employees) {
            if (emp.getPosition().equals(Position.TEAM_LEAD)) {
                for (Project proj : emp.getProjects()) {
                    if (employee.getProjects().contains(proj)) {
                        employees.add(emp);
                    }
                }
            }

        }
        return employees;
    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();
        for (Employee emp : employees) {
            for (Project proj : emp.getProjects()) {
                if (employee.getProjects().contains(proj)) {
                    employees.add(emp);
                }
            }

        }
        return employees;
    }


    public static List<Project> getEmployee1Projecs() {
        return employee1Projecs;
    }

    public static List<Project> getEmployee2Projecs() {
        return employee2Projecs;
    }

    public static List<Project> getEmployee3Projecs() {
        return employee3Projecs;
    }

    public static List<Project> getEmployee4Projecs() {
        return employee4Projecs;
    }

    public static List<Project> getEmployee5Projecs() {
        return employee5Projecs;
    }

    public static List<Project> getEmployee6Projecs() {
        return employee6Projecs;
    }

    public static List<Project> getEmployee7Projecs() {
        return employee7Projecs;
    }

    public static Employee getEmployee1() {
        return employee1;
    }

    public static Employee getEmployee2() {
        return employee2;
    }

    public static Employee getEmployee3() {
        return employee3;
    }

    public static Employee getEmployee4() {
        return employee4;
    }

    public static Employee getEmployee5() {
        return employee5;
    }

    public static Employee getEmployee6() {
        return employee6;
    }

    public static Employee getEmployee7() {
        return employee7;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }
}
