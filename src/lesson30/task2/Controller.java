package lesson30.task2;

import java.util.*;

public class Controller {
    EmployeeDAO employeeDAO=new EmployeeDAO();
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

    public Collection<Project> projectsByEmployee(Employee employee){

        return employee.getProjects();

    }

    public Collection<Employee> employeesByDepartmentWithoutProject (DepartmentType departmentType){
        Set<Employee> employees=new HashSet<>();
        Collection<Employee> departmentEmployee=null;
        for (Department dep: DepartmentDAO.department)
            if (dep.getType() == departmentType) {
                departmentEmployee = dep.getEmployees();
                for (Employee emp : departmentEmployee) {
                    if (emp!=null&&emp.getProjects().isEmpty()){
                        employees.add(emp);
                    }

                }
                return employees;
            }

        return employees;

    }

    public Collection<Employee> employeesWithoutProject (){
        Set<Employee> employees=new HashSet<>();
        for (Employee emp: EmployeeDAO.employees){
            if (emp.getProjects().isEmpty()){
                employees.add(emp);
            }
        }
        return employees;
    }

    public Collection<Employee> employeesByTeemLead (Employee lead){

        Set<Employee> employees=new HashSet<>();
        for (Employee emp: EmployeeDAO.employees){
            for (Project proj : emp.getProjects()){
                if (lead.getProjects().contains(proj)){
                    employees.add(emp);
                }
            }

        }
        return employees;
    }

    public Collection<Employee> teamLeadsByEmployee (Employee employee){
        Set<Employee> employees=new HashSet<>();
        for (Employee emp: EmployeeDAO.employees){
            if (emp.getPosition()==Position.TEAM_LEAD){
                for (Project proj : emp.getProjects()){
                    if (employee.getProjects().contains(proj)){
                        employees.add(emp);
                    }
                }
            }

        }
        return employees;
    }

    public Collection<Employee> employeesByProjectEmployee (Employee employee){
        Set<Employee> employees=new HashSet<>();
        for (Employee emp: EmployeeDAO.employees){
                            for (Project proj : emp.getProjects()){
                    if (employee.getProjects().contains(proj)){
                        employees.add(emp);
                    }
                }

        }
        return employees;
    }

    public Collection<Project> projectsByCustomer (Customer customer){
        Set<Project> project=new HashSet<>();
        for (Project proj: ProjectDAO.projects){
            if (proj.getCustomer().equals(customer)){
               project.add(proj);
            }

        }
        return project;
    }

    public Collection<Employee> employeesByCustomerProjects (Customer customer){
        Set<Employee> employees=new HashSet<>();
        Collection<Project> projects=projectsByCustomer ( customer);
         for (Project proj: projects){
             employees.addAll(employeesByProject(proj.getName()));
         }

        return employees;
    }

    }
