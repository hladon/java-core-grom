package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {
    public static Set<Project> projects=new HashSet<>();

    static Project project1=new Project("Alibaba",CustomerDAO.cust1);
    static Project project2=new Project("Amazon",CustomerDAO.cust2);
    static Project project3=new Project("Rozetka",CustomerDAO.cust3);
    static Project project4=new Project("Citrus",CustomerDAO.cust4);
    static Project project5=new Project("HotUA",CustomerDAO.cust5);

    {
        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        projects.add(project5);

    }
}
