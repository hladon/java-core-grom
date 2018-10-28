package lesson20.task2.Exception;

public  class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
