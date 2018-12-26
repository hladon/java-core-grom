package lesson36;

import lesson36.Exceptions.UserNotLogged;
import lesson36.Exceptions.WrongUserType;
import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;
import lesson36.model.User;

import java.util.Collection;
import java.util.Set;

public class Controler {
    private static User logedUser=null;

    public  Set findHotelByName(String name)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        return HotelService.findHotelByName(name);
    }

    public  Set findHotelByCity(String city)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        return HotelService.findHotelByCity(city);
    }

    public  Collection findRooms(Filter filter)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        return RoomService.findRooms(filter);
    }
    // Якщо кожна кімната має унікальне id, для чого hotelId? І куди вписувати userId?

    public void bookRoom(long roomId, long userId) throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        RoomService.roomReservation(roomId,userId);
    }
    //Тут теж мені не зрозуміло як використати UserId?
    public void cancelReservation(long roomId) throws Exception{
        RoomService.cancelReservation(roomId);

    }

    public User registerUser(User user){
        return UserService.registerUser(user);

    }

    public  void login(String userName,String password) throws Exception{
        logedUser=UserService.login(userName,password);
    }

    public void logout(){
        logedUser=null;
    }

    public Hotel addHotel(Hotel hotel)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        if (logedUser.getType().equals(UserType.ADMIN)) {

            return HotelService.addHotel(hotel);
        }
        throw new WrongUserType();
    }

    public void deleteHotel(long hotelId)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        if (logedUser.getType().equals(UserType.ADMIN)) {
        HotelService.deleteHotel(hotelId);}
    }

    public Room addRoom(Room room)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        if (logedUser.getType().equals(UserType.ADMIN)) {

            return RoomService.addRoom(room);
        }
        throw new WrongUserType();
    }

    public void deleteRoom(long roomId)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        if (logedUser.getType().equals(UserType.ADMIN)) {
            RoomService.deleteRoom(roomId);}
    }

}
