package lesson30.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Controller {
    public Collection<Employee> employeesByProject(String project) {
        Collection<Employee> workers = new HashSet<>();
        for (Employee emp : EmployeeDAO.employees) {
            for (Project proj : emp.getProjects()) {
                if (proj.getName().equalsIgnoreCase(project))
                    workers.add(emp);

            }
        }
        return workers;
    }
}
