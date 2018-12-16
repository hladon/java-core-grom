package lesson36;


import java.util.*;

public class HotelService {
    public static Hotel findHotelByName(String name){
       return find(name,1);
    }
    public static Hotel findHotelByCity(String city){
        return find(city,3);
    }
    private static Hotel find(String name,int number){
        String[] textList= Repository.getList("D:\\java-core-project\\src\\lesson36\\hotelRepository");
        String[] values;
        for (String line: textList){
            values=line.split("[,]");
            if (values[number].equals(name))
                return new Hotel(Long.valueOf(values[0]),values[1],values[2],values[3],values[4]);
        }
        return null;
    }


}
