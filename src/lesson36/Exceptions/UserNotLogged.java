package lesson36.Exceptions;

public class UserNotLogged extends Exception {
    public UserNotLogged() {
        super("User not logged in! Please login.");
    }
}
