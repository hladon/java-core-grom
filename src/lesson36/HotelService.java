package lesson36;


import java.util.*;

public class HotelService {
    public static Set findHotelByName(String name){
       return find(name,1);
    }
    public static Set findHotelByCity(String city){
        return find(city,3);
    }
    private static Set find(String name,int number){
        String[] textList= Repository.getListFromRepository("D:\\java-core-project\\src\\lesson36\\hotelRepository");
        String[] values;
        Set <Hotel> list=new HashSet<>();
        for (String line: textList){
            values=line.split("[,]");
            if (values[number].equals(name))
                list.add(new Hotel(Long.valueOf(values[0]),values[1],values[2],values[3],values[4])) ;
        }
        return list;
    }


}
