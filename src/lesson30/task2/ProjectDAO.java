package lesson30.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class ProjectDAO {


    private static Project project1 = new Project("Alibaba", CustomerDAO.cust1);
    private static Project project2 = new Project("Amazon", CustomerDAO.cust2);
    private static Project project3 = new Project("Rozetka", CustomerDAO.cust3);
    private static Project project4 = new Project("Citrus", CustomerDAO.cust4);
    private static Project project5 = new Project("HotUA", CustomerDAO.cust5);
    private static List<Project> projects = asList(project1, project2, project3, project4, project5);

    public static Set<Project> projectsByCustomer(Customer customer) {
        Set<Project> project = new HashSet<>();
        for (Project proj : projects) {
            if (proj.getCustomer().equals(customer)) {
                project.add(proj);
            }

        }
        return project;
    }

    public static Project getProject1() {
        return project1;
    }

    public static Project getProject2() {
        return project2;
    }

    public static Project getProject3() {
        return project3;
    }

    public static Project getProject4() {
        return project4;
    }

    public static Project getProject5() {
        return project5;
    }

    public static List<Project> getProjects() {
        return projects;
    }
}
