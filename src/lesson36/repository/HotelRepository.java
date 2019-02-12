package lesson36.repository;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Hotel;


public class HotelRepository extends Repository<Hotel> {
    private static String repositoryLocation = "src\\lesson36\\repository\\HotelDb";

    public HotelRepository() {
        super(repositoryLocation);
    }

    protected Hotel convert(String line) throws Exception {
        if (line == null)
            return null;
        String[] values = line.split(",");
        if (values.length != 5)
            throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged");
        return new Hotel(Long.valueOf(values[0]), values[1], values[2], values[3], values[4]);
    }

}