package lesson36;


import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;

import java.util.*;


public class HotelService {
    private static HotelRepository repository = new HotelRepository();

    public static Set findHotelByName(String name) throws Exception {
        Set<Hotel> selectedList = new HashSet<>();
        List<Hotel> list = repository.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name))
                selectedList.add(list.get(i));
        }
        return selectedList;
    }

    public static Set findHotelByCity(String city) throws Exception {
        Set<Hotel> selectedList = new HashSet<>();
        List<Hotel> list = repository.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCity().equalsIgnoreCase(city))
                selectedList.add(list.get(i));
        }
        return selectedList;
    }

    public static Set findHotelByCountry(String country) throws Exception {
        Set<Hotel> selectedList = new HashSet<>();
        List<Hotel> list = repository.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCountry().equalsIgnoreCase(country))
                selectedList.add(list.get(i));
        }
        return selectedList;
    }



    public static Hotel addHotel(Hotel hotel) throws Exception {
        return repository.save(hotel);
    }

    public static void deleteHotel(long id) throws Exception {
        repository.delete(id);
    }

}
