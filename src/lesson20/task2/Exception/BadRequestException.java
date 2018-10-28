package lesson20.task2.Exception;

public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
    public static class LimitExceeded extends BadRequestException {
        public LimitExceeded(String message) {
            super(message);
        }
    }
}
