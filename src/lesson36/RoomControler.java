package lesson36;

import lesson36.Exceptions.UserNotLogged;
import lesson36.Exceptions.WrongUserType;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.model.UserType;
import java.util.Set;

public  class RoomControler  {
    public static Set<Room> findRooms(Filter filter) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        return RoomService.findRooms(filter);
    }


    public static void bookRoom(long roomId, long userId) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        RoomService.roomReservation(roomId, userId);
    }

    public static void cancelReservation(long roomId, long userId) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        RoomService.cancelReservation(roomId, userId);

    }
    public static Room addRoom(Room room) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        if (Session.getLogedUser().getType().equals(UserType.ADMIN)) {
            return RoomService.addRoom(room);
        }
        throw new WrongUserType();
    }

    public static void deleteRoom(long roomId) throws Exception {
        if (Session.getLogedUser() == null)
            throw new UserNotLogged();
        if (Session.getLogedUser().getType().equals(UserType.ADMIN)) {
            RoomService.deleteRoom(roomId);
        }
        throw new WrongUserType();
    }
}
