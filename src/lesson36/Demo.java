package lesson36;

import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;

import java.util.Date;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) throws Exception{
        Controler controler=new Controler();

        System.out.println(controler.findHotelByName("Hilton").toString());

        System.out.println(controler.findHotelByCity("Kiev").toString());

        Filter filter=new Filter("Ukraine","Kiev",null,1,true,true,new Date());
        System.out.println(controler.findRooms(filter).toString());


    }
}
