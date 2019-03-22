package lesson36;


import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;
import lesson36.repository.HotelRepository;
import lesson36.repository.RoomRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RoomService {
    private static RoomRepository repository = new RoomRepository();
    private static HotelRepository hotelRepository=new HotelRepository();

    public static Room addRoom(Room room) throws Exception {
        return repository.save(room);
    }

    public static void deleteRoom(long id) throws Exception {
        repository.delete(id);
    }

    public static void roomReservation(long roomId, long userId) throws Exception {
        Room room = repository.findById(roomId);
        if (room == null)
            return;
        room.setDateAvailableFrom(new Date(room.getDateAvailableFrom().getTime() + 604800000));
        repository.delete(roomId);
        repository.save(room);
        OrderService.createOrder(roomId, userId);
    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        Room room = repository.findById(roomId);
        if (room == null)
            return;
        room.setDateAvailableFrom(new Date());
        repository.delete(roomId);
        repository.save(room);
        OrderService.deleteOrder(roomId, userId);
    }


    public static Set<Room> findRooms(Filter filter) throws Exception {
        List<Room> list = repository.getList();
        Set<Hotel> hotels = HotelService.findHotelByCity(filter.getCity());
        hotels.addAll(HotelService.findHotelByName(filter.getHotel()));
        hotels.addAll(HotelService.findHotelByCountry(filter.getCountry()));
        Set<Room> rooms = new HashSet<>();
        for (Room room : list) {
            if (room.getDateAvailableFrom().before(filter.getDateAvaibleFrom()) &&
                    room.isBreakfastIncluded() == filter.isBreakfastIncluded() &&
                    room.isPetsAllowed() == filter.isPetsAllowed() &&
                    room.getNumberOfGuests() >= filter.getNumberOfGuests() &&
                    checkHotelForRoom(room, filter)) {
                    rooms.add(room);
            }

        }
        return rooms;
    }


    private static boolean checkHotelForRoom(Room room, Filter filter) {
        return room.getHotel().getCountry().equalsIgnoreCase(filter.getCountry())&&
                room.getHotel().getCity().equalsIgnoreCase(filter.getCity())&&
                room.getHotel().getName().equalsIgnoreCase(filter.getHotel());
    }

}
