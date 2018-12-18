package lesson36;


import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Hotel;

import java.util.*;
import java.util.regex.Pattern;

public class HotelService {
    private static Pattern pattern=Pattern.compile("\\d+,\\w+,\\w+,\\w+,\\w+");
    private static String repositoryLocation="D:\\java-core-project\\src\\lesson36\\repository\\hotelRepository.txt";

    public static Set findHotelByName(String name)throws RepositoryDamaged {
       return find(name,1);
    }
    public static Set findHotelByCity(String city)throws RepositoryDamaged{
        return find(city,3);
    }
    private static Set find(String name,int number)throws RepositoryDamaged{
        String[] textList= Repository.getListFromRepository(repositoryLocation);
        String[] values;
        Set <Hotel> list=new HashSet<>();
        for (String line: textList){
            Repository.checkDataFromRepository(pattern,line,repositoryLocation);
            values=line.split("[,]");
            if (values[number].equals(name))
                list.add(new Hotel(Long.valueOf(values[0]),values[1],values[2],values[3],values[4])) ;
        }
        return list;
    }

    public static Hotel addHotel (Hotel hotel){
        Repository.add(repositoryLocation,hotel.toString());
        return hotel;
    }


}
