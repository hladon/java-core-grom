package lesson36;

import lesson36.Exceptions.WrongUserType;
import lesson36.model.User;
import lesson36.model.UserType;

public class UserControler extends Controler {
    public static User registerUser(User user) throws Exception {
        if ( user.getType().equals(UserType.ADMIN)&&(logedUser==null||logedUser.getType().equals(UserType.USER)))
            throw new WrongUserType();
        return UserService.registerUser(user);

    }

    public static void login(String userName, String password) throws Exception {
        logedUser = UserService.login(userName, password);
    }

    public static void logout() {
        logedUser = null;
    }
}
