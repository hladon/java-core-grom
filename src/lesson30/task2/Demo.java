package lesson30.task2;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        System.out.println(controller.employeesByProject("amazon"));

        System.out.println(controller.projectsByEmployee(EmployeeDAO.employee1));

        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.FINANCE));

        System.out.println(controller.employeesWithoutProject());

        System.out.println(controller.employeesByTeemLead(EmployeeDAO.employee7));

        System.out.println(controller.teamLeadsByEmployee(EmployeeDAO.employee5));

        System.out.println(controller.employeesByProjectEmployee(EmployeeDAO.employee5));

        System.out.println(controller.projectsByCustomer(CustomerDAO.cust1));

        System.out.println(controller.employeesByCustomerProjects(CustomerDAO.cust1));

    }
}
