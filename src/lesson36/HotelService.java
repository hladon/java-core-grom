package lesson36;


import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Hotel;

import java.util.*;
import java.util.regex.Pattern;

public class HotelService {
    private static Pattern rightDataStructure=Pattern.compile("\\d+,\\w+,\\w+,\\w+,\\w+");
    private static String repositoryLocation="D:\\java-core-project\\src\\lesson36\\repository\\HotelDb.txt";

    public static Set findHotelByName(String name)throws RepositoryDamaged {
       return find(name,1);
    }
    public static Set findHotelByCity(String city)throws RepositoryDamaged{
        return find(city,3);
    }
    public static Set findHotelByCountry(String country)throws RepositoryDamaged{
        return find(country,2);
    }
    private static Set find(String stringToFind,int slot)throws RepositoryDamaged{
        String[] textList= Repository.getListFromRepository(repositoryLocation,rightDataStructure);
        Set<String> stringsList= Repository.find(stringToFind,slot,textList);
        String[] values;
        Set <Hotel> list=new HashSet<>();
        for (String line: stringsList){
            values=line.split("[,]");
            list.add(new Hotel(Long.valueOf(values[0]),values[1],values[2],values[3],values[4])) ;
        }
        return list;
    }

    public static Hotel addHotel (Hotel hotel){
        Repository.add(repositoryLocation,hotel.toString());
        return hotel;
    }
    public static void deleteHotel(long id){
        Repository.changeData(id,repositoryLocation,"");
    }

}
