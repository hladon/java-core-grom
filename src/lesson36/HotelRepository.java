package lesson36;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Hotel;
import lesson36.model.Room;

import java.util.List;
import java.util.regex.Pattern;

public class HotelRepository extends Repository {
    private static String repositoryLocation = "src\\lesson36\\repository\\HotelDb";
    public static List list;

    public static List<Hotel> getList() throws Exception{
        for (String line:getListFromRepository(repositoryLocation) ) {
            String[] values = line.split(",");
            if (values.length<5)
                throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged") ;
            list.add(new Hotel(Long.valueOf(values[0]), values[1], values[2], values[3], values[4]));
        }
        return list;
    }


}
