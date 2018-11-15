package lesson30.task2;

public class Demo {
    public static void main(String[] args) {
     Controller controller=new Controller();
     EmployeeDAO employeeDAO=new EmployeeDAO();

     System.out.println(controller.employeesByProject("amazon"));

     System.out.println(controller.projectsByEmployee(employeeDAO.employee1));
    }
}
