package lesson36;


import lesson36.model.Hotel;

import java.util.*;
import java.util.regex.Pattern;

public class HotelService {
    private static Pattern rightDataStructure = Pattern.compile("\\d+,\\w+,\\w+,\\w+,\\w+");
    private static String repositoryLocation = "src\\lesson36\\repository\\HotelDb";

    public static Set findHotelByName(String name) throws Exception {
        return find(name, 1);
    }

    public static Set findHotelByCity(String city) throws Exception {
        return find(city, 3);
    }

    public static Set findHotelByCountry(String country) throws Exception {
        return find(country, 2);
    }

    private static Set find(String stringToFind, int slot) throws Exception {
        String[] textList = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
        Set<String> stringsList = Repository.find(stringToFind, slot, textList);
        Set<Hotel> list = new HashSet<>();
        for (String line : stringsList) {
            list.add(stringToHotel(line));
        }
        return list;
    }

    public static Hotel stringToHotel(String line) {
        String[] values = line.split(",");
        return new Hotel(Long.valueOf(values[0]), values[1], values[2], values[3], values[4]);
    }

    public static Hotel addHotel(Hotel hotel) throws Exception {
        String[] values = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
        Repository.changeData(hotel.getId(), repositoryLocation, values, hotel.toString());
        return hotel;
    }

    public static void deleteHotel(long id) throws Exception {
        String[] values = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
        Repository.changeData(id, repositoryLocation, values, null);
    }

}
