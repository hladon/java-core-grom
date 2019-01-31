package lesson36;


import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;

import java.util.*;


public class HotelService {
    private static HotelRepository repository = new HotelRepository();

    public static Set findHotelByName(String name) throws Exception {
        return find(name, 1);
    }

    public static Set findHotelByCity(String city) throws Exception {
        return find(city, 2);
    }

    public static Set findHotelByCountry(String country) throws Exception {
        return find(country, 3);
    }

    private static Set find(String name, int variant) throws Exception {
        Set<Hotel> selectedList = new HashSet<>();
        List<Hotel> list = repository.getList();
        switch (variant) {
            case 1:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equalsIgnoreCase(name))
                        selectedList.add(list.get(i));
                }
                break;
            case 2:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCity().equalsIgnoreCase(name))
                        selectedList.add(list.get(i));
                }
                break;
            case 3:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCountry().equalsIgnoreCase(name))
                        selectedList.add(list.get(i));
                }
                break;
        }
        return selectedList;
    }


    public static Hotel addHotel(Hotel hotel) throws Exception {
        return repository.add(hotel);
    }

    public static void deleteHotel(long id) throws Exception {
        repository.delete(id);
    }

}
