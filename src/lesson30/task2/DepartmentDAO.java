package lesson30.task2;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
	public static Set<Department> departments = new HashSet<>();
	ArrayList findep = new ArrayList();
	ArrayList devdep = new ArrayList();
	ArrayList saldep = new ArrayList();

	{
		findep.add(EmployeeDAO.employee1);
		findep.add(EmployeeDAO.employee4);
		devdep.add(EmployeeDAO.employee2);
		devdep.add(EmployeeDAO.employee3);
		devdep.add(EmployeeDAO.employee5);
		devdep.add(EmployeeDAO.employee7);
		saldep.add(EmployeeDAO.employee6);
	}
	Department finance = new Department(DepartmentType.FINANCE, findep);
	Department developing = new Department(DepartmentType.DEVELOPING, devdep);
	Department sales = new Department(DepartmentType.SALES, saldep);
	{
		departments.add(finance);
		departments.add(developing);
		departments.add(sales);

	}
}
