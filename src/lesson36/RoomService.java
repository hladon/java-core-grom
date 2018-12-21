package lesson36;


import lesson36.model.Room;

import java.util.regex.Pattern;

public class RoomService {
    private static Pattern pattern=Pattern.compile("\\d+,\\d+,\\d+,[true|false],[true|false],\\d+,\\w+");
    private static String repositoryLocation="D:\\java-core-grom\\java2\\src\\lesson36\\repository\\RoomDb.txt";

    public static Room addRoom (Room room){
        Repository.add(repositoryLocation,room.toString());
        return room;
    }

    public static void deleteRoom(long id){
        Repository.changeData(id,repositoryLocation,"");
    }

    public static void roomReservation(long roomId, long userId){

    }
}
