package lesson36;

import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;
import lesson36.model.User;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) throws Exception{
        Controler controler=new Controler();
        controler.login("Vlad","trew");
//        System.out.println(controler.findHotelByName("Hilton").toString());
//
//        System.out.println(controler.findHotelByCity("Kiev").toString());

//        Filter filter=new Filter("Ukraine","Kiev",null,1,true,false,new Date());
//        System.out.println(controler.findRooms(filter).toString());
        User user=new User(7,"Sergey","crad","Ukraine",UserType.USER);
        System.out.println(controler.registerUser(user));

//        Pattern pattern=Pattern.compile("\\d+,\\d+,\\d+,(true|false),(true|false),\\d+,\\d+");
//
//        System.out.println(pattern.matcher("1,2,100,true,false,1545854554307,1").matches());
    }
}
