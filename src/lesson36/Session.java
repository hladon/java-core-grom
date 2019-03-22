package lesson36;

import lesson36.model.*;

public class Session {
    private static User logedUser = null;

    public static User getLogedUser() {
        return logedUser;
    }

    public static void setLogedUser(User logedUser) {
        Session.logedUser = logedUser;
    }
}
