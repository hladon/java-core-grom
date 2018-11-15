package lesson30.task2;

import java.util.*;

import static java.util.Arrays.asList;

public class EmployeeDAO {

    public DepartmentDAO departmentDAO = new DepartmentDAO();

    public Collection<Project> employee1Projecs = new ArrayList<>();
    public Collection<Project> employee2Projecs = new ArrayList<>();
    public Collection<Project> employee3Projecs = new ArrayList<>();
    public Collection<Project> employee4Projecs = new ArrayList<>();
    public Collection<Project> employee5Projecs = new ArrayList<>();
    public Collection<Project> employee6Projecs = new ArrayList<>();
    public Collection<Project> employee7Projecs = new ArrayList<>();

    public static  Employee employee1 = new Employee("Derek", "Smith", new Date(28 / 10 / 2011), Position.ANALYST, departmentDAO.finance, employee1Projecs);
    public static  Employee employee2 = new Employee("Boris", "Bobko", new Date(28 / 10 / 2011), Position.DESIGNER, departmentDAO.developing, employee2Projecs);
    public static  Employee employee3 = new Employee("Lara", "Lah", new Date(28 / 10 / 2011), Position.DEVELOPER, departmentDAO.developing, employee3Projecs);
    public  static Employee employee4 = new Employee("Fedir", "Johns", new Date(28 / 10 / 2011), Position.FINANCE, departmentDAO.finance, employee4Projecs);
    public static  Employee employee5 = new Employee("Nelia", "Dram", new Date(28 / 10 / 2011), Position.LEAD_DESIGNER, departmentDAO.developing, employee5Projecs);
    public static  Employee employee6 = new Employee("Katrin", "Denef", new Date(28 / 10 / 2011), Position.MANAGER, departmentDAO.sales, employee6Projecs);
    public  static Employee employee7 = new Employee("Will", "Smith", new Date(28 / 10 / 2011), Position.TEAM_LEAD, departmentDAO.developing, employee7Projecs);

    public static List<Employee> employees=asList(employee1,employee3,employee2,employee4,employee5,employee6,employee7);
    public EmployeeDAO() {

        employee1Projecs.add(ProjectDAO.project1);
        employee1Projecs.add(ProjectDAO.project2);
        employee1Projecs.add(ProjectDAO.project3);
        employee2Projecs.add(ProjectDAO.project3);
        employee2Projecs.add(ProjectDAO.project4);
        employee2Projecs.add(ProjectDAO.project5);
        employee3Projecs.add(ProjectDAO.project5);
        employee3Projecs.add(ProjectDAO.project1);
        employee3Projecs.add(ProjectDAO.project2);
        employee4Projecs.add(ProjectDAO.project3);
        employee4Projecs.add(ProjectDAO.project4);
        employee4Projecs.add(ProjectDAO.project5);
        employee5Projecs.add(ProjectDAO.project4);
        employee5Projecs.add(ProjectDAO.project3);
        employee5Projecs.add(ProjectDAO.project2);
        employee6Projecs.add(ProjectDAO.project1);
        employee6Projecs.add(ProjectDAO.project4);
        employee6Projecs.add(ProjectDAO.project5);
        employee7Projecs.add(ProjectDAO.project3);
        employee7Projecs.add(ProjectDAO.project4);
        employee7Projecs.add(ProjectDAO.project5);
    }


}
