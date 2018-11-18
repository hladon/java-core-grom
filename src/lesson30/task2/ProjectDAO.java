package lesson30.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class ProjectDAO {


    public static Project project1 = new Project("Alibaba", CustomerDAO.cust1);
    public static Project project2 = new Project("Amazon", CustomerDAO.cust2);
    public static Project project3 = new Project("Rozetka", CustomerDAO.cust3);
    public static Project project4 = new Project("Citrus", CustomerDAO.cust4);
    public static Project project5 = new Project("HotUA", CustomerDAO.cust5);
    public static List<Project> projects = asList(project1, project2, project3, project4, project5);


}
