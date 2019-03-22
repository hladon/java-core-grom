package lesson36;

import lesson36.Exceptions.WrongUserType;
import lesson36.model.User;
import lesson36.model.UserType;

public class UserControler  {
    public static User registerUser(User user) throws Exception {
        if ( user.getType().equals(UserType.ADMIN)&&(Session.getLogedUser()==null||
                Session.getLogedUser().getType().equals(UserType.USER)))
            throw new WrongUserType();
        return UserService.registerUser(user);

    }

    public static void login(String userName, String password) throws Exception {
        Session.setLogedUser(UserService.login(userName, password));
    }

    public static void logout() {
        Session.setLogedUser(null);
    }
}
