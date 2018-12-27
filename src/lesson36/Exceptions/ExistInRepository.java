package lesson36.Exceptions;

public class ExistInRepository extends Exception {
    public ExistInRepository() {
        super("Object exist in repository!");
    }
}
