package lesson36;


import lesson36.model.Room;

import java.util.Date;
import java.util.Set;
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

    public static void roomReservation(long roomId, long userId) throws Exception{
        String object=Repository.findById(String.valueOf(roomId),Repository.getListFromRepository(repositoryLocation,pattern));
        String[] fields=object.split(",");
        //резервую на 7 днів
        Long availableFrom=Long.valueOf(fields[5])+604800000;
        fields[5]=String.valueOf(availableFrom);
        StringBuffer newData=new StringBuffer();
        for (String field:fields){
            newData.append(field);
            newData.append(",");
        }
        newData.delete(newData.length()-2,newData.length()-1);

        Repository.changeData(roomId,repositoryLocation,String.valueOf(newData));
    }

    public static void cancelReservation (long id) throws Exception{
        String object=Repository.findById(String.valueOf(id),Repository.getListFromRepository(repositoryLocation,pattern));
        String[] fields=object.split(",");
        Date date=new Date();
        fields[5]=String.valueOf(date.getTime());
        StringBuffer newData=new StringBuffer();
        for (String field:fields){
            newData.append(field);
            newData.append(",");
        }
        newData.delete(newData.length()-2,newData.length()-1);

        Repository.changeData(id,repositoryLocation,String.valueOf(newData));
    }
}
