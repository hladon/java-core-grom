package lesson22.hw.Exception;

public  class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
