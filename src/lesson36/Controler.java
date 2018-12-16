package lesson36;

import java.util.Collection;

public class Controler {
    public static Hotel findHotelByName(String name){
        return HotelService.findHotelByName(name);
    }
    public static Hotel findHotelByCity(String city){
        return HotelService.findHotelByCity(city);
    }
    public static Collection findRooms(Filter filter){

    }
}
