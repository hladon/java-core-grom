package lesson36;

import lesson36.Exceptions.UserNotLogged;
import lesson36.Exceptions.WrongUserType;
import lesson36.model.Hotel;
import lesson36.model.UserType;

import java.util.Set;

public class HotelControler  {

    public static Set findHotelByName(String name) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        return HotelService.findHotelByName(name);
    }

    public static Set findHotelByCity(String city) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        return HotelService.findHotelByCity(city);
    }
    public static Hotel addHotel(Hotel hotel) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        if (Session.getLogedUser().getType().equals(UserType.ADMIN)) {

            return HotelService.addHotel(hotel);
        }
        throw new WrongUserType();
    }

    public static void deleteHotel(long hotelId) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        if (Session.getLogedUser().getType().equals(UserType.ADMIN)) {
            HotelService.deleteHotel(hotelId);
        }
    }
}
