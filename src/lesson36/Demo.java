package lesson36;

import lesson36.model.Hotel;
import lesson36.model.Room;

import java.util.Date;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Room room=new Room(12,12,34.00,true,true,new Date(),new Hotel(32,"fljg;","dk;fg","ksdf","lsd;jf"));
        Date d=new Date();

        System.out.println(d.getTime());
    }
}
