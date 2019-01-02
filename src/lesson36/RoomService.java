package lesson36;



import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class RoomService {
    private static Pattern rightDataStructure = Pattern.compile("\\d+,\\d+,[0-9.]+,(true|false),(true|false),\\d+,\\d+");
    private static String repositoryLocation = "src\\lesson36\\repository\\RoomDb";

    public static Room addRoom(Room room) throws Exception {
        String[] values = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
        Repository.changeData(room.getId(), repositoryLocation, values, room.toString());
        return room;
    }

    public static void deleteRoom(long id) throws Exception {
        String[] values = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
        Repository.changeData(id, repositoryLocation, values, null);
    }

    public static void bookRoom(long roomId, long userId) throws Exception {
        reservationOperation(roomId, true);
        OrderService.createOrder(roomId, userId);
    }

    public static void cancelReservation(long roomId, long userId) throws Exception {
        reservationOperation(roomId, false);
        OrderService.deleteOrder(roomId, userId);
    }

    private static void reservationOperation(long roomId, boolean changer) throws Exception {
        String[] objectList = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
        String[] fields = Repository.findById(roomId, objectList).split(",");
        if (changer) {
            //        Резервую на 7 днів.
            Long availableFrom = Long.valueOf(fields[5]) + 604800000;
            fields[5] = String.valueOf(availableFrom);
        } else {
            Date date = new Date();
            fields[5] = String.valueOf(date.getTime());
        }
        StringBuffer newData = new StringBuffer();
        for (String field : fields) {
            newData.append(field);
            newData.append(",");
        }
        newData.delete(newData.length() - 1, newData.length());
        Repository.changeData(roomId, repositoryLocation, objectList, String.valueOf(newData));
    }

    public static Set<Room> findRooms(Filter filter) throws Exception {
        Set<Hotel> hotels = HotelService.findHotelByCity(filter.getCity());
        hotels.addAll(HotelService.findHotelByName(filter.getHotel()));
        hotels.addAll(HotelService.findHotelByCountry(filter.getCountry()));
        String[] dataBase = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
        Set<Room> rooms = new HashSet<>();
        String[] operationWords;
        for (String room : dataBase) {
            operationWords = room.split(",");
            if (checker(operationWords, filter)) {
                rooms = checkHotelForRoom(operationWords, hotels);
            }
        }
        return rooms;
    }

    private static boolean checker(String[] operationWords, Filter filter) {
        return Integer.valueOf(operationWords[1]) >= filter.getNumberOfGuests() &&
                Boolean.valueOf(operationWords[3]) == filter.isBreakfastIncluded() &&
                Boolean.valueOf(operationWords[4]) == filter.isPetsAllowed() &&
                Long.valueOf(operationWords[5]) < filter.getDateAvaibleFrom().getTime();
    }

    private static Set<Room> checkHotelForRoom(String[] operationWords, Set<Hotel> hotels) {
        Set<Room> rooms = new HashSet<>();
        for (Hotel hotel : hotels) {
            if (Long.valueOf(operationWords[6]) == hotel.getId()) {
                rooms.add(new Room(Long.valueOf(operationWords[0]), Integer.valueOf(operationWords[1]),
                        Double.valueOf(operationWords[2]), Boolean.valueOf(operationWords[3]),
                        Boolean.valueOf(operationWords[4]), new Date(Long.valueOf(operationWords[5])), hotel));
            }
        }
        return rooms;
    }

}
