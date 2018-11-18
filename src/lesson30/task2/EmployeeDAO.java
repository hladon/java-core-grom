package lesson30.task2;

import java.util.*;

import static java.util.Arrays.asList;

public class EmployeeDAO {


    public static List<Project> employee1Projecs=asList(ProjectDAO.project1,ProjectDAO.project2,ProjectDAO.project3);
    public static List<Project> employee2Projecs=asList(ProjectDAO.project2,ProjectDAO.project3,ProjectDAO.project4);
    public static List<Project> employee3Projecs=asList(ProjectDAO.project3,ProjectDAO.project4,ProjectDAO.project5);
    public static List<Project> employee4Projecs=asList(ProjectDAO.project4,ProjectDAO.project5,ProjectDAO.project1);
    public static List<Project> employee5Projecs=asList(ProjectDAO.project5,ProjectDAO.project1,ProjectDAO.project3);
    public static List<Project> employee6Projecs=asList();
    public static List<Project> employee7Projecs=asList(ProjectDAO.project1,ProjectDAO.project2,ProjectDAO.project3);

    public static  Employee employee1 = new Employee("Derek", "Smith", new Date(28 / 10 / 2011), Position.ANALYST, DepartmentDAO.finance, employee1Projecs);
    public static  Employee employee2 = new Employee("Boris", "Bobko", new Date(28 / 10 / 2011), Position.DESIGNER, DepartmentDAO.developing, employee2Projecs);
    public static  Employee employee3 = new Employee("Lara", "Lah", new Date(28 / 10 / 2011), Position.DEVELOPER, DepartmentDAO.developing, employee3Projecs);
    public  static Employee employee4 = new Employee("Fedir", "Johns", new Date(28 / 10 / 2011), Position.FINANCE, DepartmentDAO.finance, employee4Projecs);
    public static  Employee employee5 = new Employee("Nelia", "Dram", new Date(28 / 10 / 2011), Position.LEAD_DESIGNER, DepartmentDAO.developing, employee5Projecs);
    public static  Employee employee6 = new Employee("Katrin", "Denef", new Date(28 / 10 / 2011), Position.MANAGER, DepartmentDAO.sales, employee6Projecs);
    public  static Employee employee7 = new Employee("Will", "Smith", new Date(28 / 10 / 2011), Position.TEAM_LEAD, DepartmentDAO.developing, employee7Projecs);

    public static List<Employee> employees=asList(employee1,employee3,employee2,employee4,employee5,employee6,employee7);



}
