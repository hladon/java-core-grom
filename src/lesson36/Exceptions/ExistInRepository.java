package lesson36.Exceptions;

public class ExistInRepository extends Exception {
    public ExistInRepository() {
        super("This profile already exist in repository");
    }
}
