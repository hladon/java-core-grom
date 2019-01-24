package lesson36;


import lesson36.model.Hotel;

import java.util.*;
import java.util.regex.Pattern;

public class HotelService {


    public static Set findHotelByName(String name) throws Exception {
        Set<Hotel> list=new TreeSet<Hotel>();
        for (Hotel line : HotelRepository.getList()) {
            if (line.getCity().equalsIgnoreCase(name))
                list.add(line);
        }
        return list;
    }

    public static Set findHotelByCity(String city) throws Exception {
        Set<Hotel> list=new TreeSet<Hotel>();
        for (Hotel line : HotelRepository.getList()) {
            if (line.getCity().equalsIgnoreCase(city))
                list.add(line);
        }
        return list;
    }

    public static Set findHotelByCountry(String country) throws Exception {
        Set<Hotel> list=new TreeSet<Hotel>();
        for (Hotel line : HotelRepository.getList()) {
            if (line.getCountry().equalsIgnoreCase(country))
                list.add(line);
        }
        return list;
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
