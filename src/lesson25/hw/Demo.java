package lesson25.hw;


import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO<Order> generalDAO = new GeneralDAO();
        GeneralDAO<IdEntity> generalDAO2 = new GeneralDAO();
        GeneralDAO<TestClass> generalDAO3 = new GeneralDAO();
        Order order = new Order();
        IdEntity idEntity=new IdEntity();
        TestClass testClass=new TestClass();


        generalDAO.save(order);
        generalDAO2.save(idEntity);
        generalDAO3.save(testClass);

        System.out.println(Arrays.deepToString(generalDAO.getAll()));
        System.out.println(Arrays.deepToString(generalDAO2.getAll()));
        System.out.println(Arrays.deepToString(generalDAO3.getAll()));

    }
}
