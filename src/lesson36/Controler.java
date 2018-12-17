package lesson36;

import java.util.Collection;
import java.util.Set;

public class Controler {
    private static User logedUser=null;
    public static Set findHotelByName(String name){
        return HotelService.findHotelByName(name);
    }
    public static Set findHotelByCity(String city){
        return HotelService.findHotelByCity(city);
    }
    public static Collection findRooms(Filter filter){
        return null;
    }
    public static void login(String userName,String password){
        logedUser=UserService.login(userName,password);
    }

    public static void logout(){
        logedUser=null;
    }

}
