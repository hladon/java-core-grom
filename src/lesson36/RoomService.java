package lesson36;


import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class RoomService {
    private static Pattern rightDataStructure=Pattern.compile("\\d+,\\d+,\\d+,(true|false),(true|false),\\d+,\\d+");
    private static String repositoryLocation="src\\lesson36\\repository\\RoomDb";

    public static Room addRoom (Room room) throws Exception{
        String[] values=Repository.getListFromRepository(repositoryLocation,rightDataStructure);
        Repository.changeData(room.getId(),repositoryLocation,values,room.toString());
        return room;
    }

    public static void deleteRoom(long id) throws Exception{
        String[] values=Repository.getListFromRepository(repositoryLocation,rightDataStructure);
        Repository.changeData(id,repositoryLocation,values,null);
    }

//    public static void roomReservation(long roomId, long userId) throws Exception{
//        String object=Repository.findById(roomId,Repository.getListFromRepository(repositoryLocation,pattern));
//        String[] fields=object.split(",");
//        Long availableFrom=Long.valueOf(fields[5])+604800000;
//        fields[5]=String.valueOf(availableFrom);
//        StringBuffer newData=new StringBuffer();
//        for (String field:fields){
//            newData.append(field);
//            newData.append(",");
//        }
//        newData.append(String.valueOf(userId));
//        Repository.changeData(roomId,repositoryLocation,String.valueOf(newData));
//    }
//    public static void cancelReservation (long id) throws Exception{
//        String object=Repository.findById(id,Repository.getListFromRepository(repositoryLocation,pattern));
//        String[] fields=object.split(",");
//        Date date=new Date();
//        fields[5]=String.valueOf(date.getTime());
//        StringBuffer newData=new StringBuffer();
//        for (String field:fields){
//            newData.append(field);
//            newData.append(",");
//        }
//        newData.delete(newData.length()-2,newData.length()-1);
//        Repository.changeData(id,repositoryLocation,String.valueOf(newData));
//    }
    public static Set<Room> findRooms(Filter filter) throws RepositoryDamaged {
        Set<Hotel> hotels=HotelService.findHotelByCity(filter.getCity());
        hotels.addAll(HotelService.findHotelByName(filter.getHotel()));
        hotels.addAll(HotelService.findHotelByCountry(filter.getCountry()));
        String[] dataBase=Repository.getListFromRepository(repositoryLocation,rightDataStructure);
        Set<Room> rooms=new HashSet<>();
        String[] operationWords;
        for(String room:dataBase){
            operationWords=room.split(",");
            if(checker(operationWords,filter)){
                for (Hotel hotel:hotels){
                    if(Long.valueOf(operationWords[6])==hotel.getId()){
                        rooms.add(new Room(Long.valueOf(operationWords[0]),Integer.valueOf(operationWords[1]),
                                Double.valueOf(operationWords[2]),Boolean.valueOf(operationWords[3]),
                                        Boolean.valueOf(operationWords[4]),new Date(Long.valueOf(operationWords[5])),hotel));}
                }
            }
        }
        return rooms;
    }
    private static boolean checker(String[]operationWords,Filter filter){
        return Integer.valueOf(operationWords[1]) >= filter.getNumberOfGuests() &&
                Boolean.valueOf(operationWords[3]) == filter.isBreakfastIncluded() &&
                Boolean.valueOf(operationWords[4]) == filter.isPetsAllowed() &&
                Long.valueOf(operationWords[5]) < filter.getDateAvaibleFrom().getTime();
    }

}
