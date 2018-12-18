package lesson36.Exceptions;

public class WrongUserType extends Exception {
    public WrongUserType() {
        super("This action not allowed!");
    }
}
