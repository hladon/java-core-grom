package lesson26;

import java.util.ArrayList;

public class ArrayListTest {

    public static ArrayList<Order> useList() {
        Order order = new Order(123, 24, "USD", "transfer", "Amazon");
        Order order2 = new Order(124, 40, "USD", "pay", "Amazon");
        ArrayList<Order> list = new ArrayList<>();
        list.add(order);
        list.add(1, order);

        list.remove(0);
        list.remove(order);


        ArrayList<Order> list1 = new ArrayList<>();
        list1.add(order2);
        list1.add(order2);
        list.addAll(list1);
        list.addAll(list.subList(0, 1));

        list.set(2, order2);

        boolean test = list.contains(order);

        Object[] array = list.toArray();

        list1.clear();
        list.add(order);
        list.add(order2);
        return list;


    }
}
