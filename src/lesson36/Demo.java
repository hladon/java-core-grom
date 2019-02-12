package lesson36;

import lesson36.model.*;


import java.util.Date;


public class Demo {
    public static void main(String[] args) throws Exception {

        UserControler.login("Vlad", "trew");

        System.out.println(HotelControler.findHotelByName("Hilton").toString());
        System.out.println(HotelControler.findHotelByName("Avenue").toString());
        System.out.println(HotelControler.findHotelByName("Relax").toString());

        System.out.println(HotelControler.findHotelByCity("Kiev").toString());
        System.out.println(HotelControler.findHotelByCity("rome").toString());
        System.out.println(HotelControler.findHotelByCity("lvov").toString());

        Filter filter = new Filter("Ukraine", "Kiev", null, 1, true, false, new Date());
        System.out.println(RoomControler.findRooms(filter).toString());

        User user = new User(8, "Vasil", "rewt", "Ukraine", UserType.USER);
        System.out.println(UserControler.registerUser(user));

        RoomControler.bookRoom(1, 1);

        RoomControler.cancelReservation(1, 1);

        Hotel hotel = new Hotel(18, "Stelar", "China", "Beijing", "MaoDezdun");
        HotelControler.addHotel(hotel);
        HotelControler.deleteHotel(18);

        Room room = new Room(13, 2, 200, true, false, new Date(), hotel);
        RoomControler.addRoom(room);
        RoomControler.deleteRoom(13);

    }
}
