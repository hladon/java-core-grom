package lesson36.repository;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Order;

import java.util.Date;


public class OrderRepository extends Repository<Order> {
    private static String repositoryLocation = "src\\lesson36\\repository\\OrderDb";
    private static UserRepository userRepository = new UserRepository();
    private static RoomRepository roomRepository = new RoomRepository();


    public OrderRepository() {
        super(repositoryLocation);
    }

    public Order convert(String line) throws Exception {
        if (line == null)
            return null;
        String[] values = line.split(",");
        if (values.length != 6)
            throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged");
        return new Order(Long.valueOf(values[0]), userRepository.findById(Long.valueOf(values[1])),
                roomRepository.findById(Long.valueOf(values[2])), new Date(Long.valueOf(values[3])),
                new Date(Long.valueOf(values[4])), Double.valueOf(values[5]));
    }
}
