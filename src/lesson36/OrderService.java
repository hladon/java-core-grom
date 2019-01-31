package lesson36;


import lesson36.model.Order;
import lesson36.repository.OrderRepository;

import java.util.*;


public class OrderService {
    private static OrderRepository repository = new OrderRepository();

    public static void createOrder(long roomId, long userId) throws Exception {
        Date dateCreated = new Date();
        long id = dateCreated.getTime();
        long dateTo = id + 604800000;
        String orderData = id + "," + userId + "," + roomId + "," + id + "," + dateTo + "," + 0;
        repository.add(repository.convert(orderData));
    }

    private static Order find(long roomId, long userId) throws Exception {
        List<Order> list = repository.getList();
        for (Order order : list) {
            if (order.getRoom().getId() == roomId && order.getUser().getId() == userId)
                return order;
        }
        return null;
    }

    public static void deleteOrder(long roomId, long userId) throws Exception {
        repository.delete(find(roomId, userId).getId());
    }
}
