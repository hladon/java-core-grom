package lesson30.task2;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        System.out.println(Controller.employeesByProject("amazon"));

        System.out.println(Controller.projectsByEmployee(EmployeeDAO.getEmployee1()));

        System.out.println(Controller.employeesByDepartmentWithoutProject(DepartmentType.FINANCE));

        System.out.println(Controller.employeesWithoutProject());

        System.out.println(Controller.employeesByTeemLead(EmployeeDAO.getEmployee7()));

        System.out.println(Controller.teamLeadsByEmployee(EmployeeDAO.getEmployee5()));

        System.out.println(Controller.employeesByProjectEmployee(EmployeeDAO.getEmployee5()));

        System.out.println(Controller.projectsByCustomer(CustomerDAO.cust1));

        System.out.println(Controller.employeesByCustomerProjects(CustomerDAO.cust1));

    }
}
