package lesson36;

import lesson36.Exceptions.UserNotLogged;
import lesson36.model.Filter;
import lesson36.model.User;

import java.util.Collection;
import java.util.Set;

public class Controler {
    private static User logedUser=null;

    public  Set findHotelByName(String name)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        return HotelService.findHotelByName(name);
    }

    public  Set findHotelByCity(String city)throws Exception{
        if (logedUser==null)
            throw new UserNotLogged();
        return HotelService.findHotelByCity(city);
    }

    public  Collection findRooms(Filter filter){
        return null;
    }

    public  void login(String userName,String password) throws Exception{
        logedUser=UserService.login(userName,password);
    }

    public void logout(){
        logedUser=null;
    }

}
