package lesson36;

import java.util.List;

public class HotelService {
    public static Hotel findHotelByName(String name){
       List<Hotel> hotelList= HotelRepository.getHotels();
       for (Hotel hotel:hotelList){
           if (hotel.getName().equalsIgnoreCase(name))
               return hotel;
       }
       return null;
    }
}
