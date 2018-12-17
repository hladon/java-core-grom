package lesson36.Exceptions;

public class RepositoryDamaged extends Exception {
    public RepositoryDamaged(String message) {
        super(message);
    }
}
