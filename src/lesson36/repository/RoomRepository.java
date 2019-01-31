package lesson36.repository;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Room;


import java.util.Date;

public class RoomRepository extends Repository {
    private static String repositoryLocation = "src\\lesson36\\repository\\RoomDb";
    private static HotelRepository hotelRepository = new HotelRepository();

    public RoomRepository() {
        super(repositoryLocation);
    }

    protected Room convert(String line) throws Exception {
        if (line == null)
            return null;
        String[] values = line.split(",");
        if (values.length != 7)
            throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged");

        return new Room(Long.valueOf(values[0]), Integer.valueOf(values[1]), Double.valueOf(values[2]),
                Boolean.valueOf(values[3]), Boolean.valueOf(values[4]), new Date(Long.valueOf(values[5])),
                hotelRepository.findById(Long.valueOf(values[6])));
    }
}
