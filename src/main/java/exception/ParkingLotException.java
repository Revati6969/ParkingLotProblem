package exception;

public class ParkingLotException extends Exception {

    public ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        PARKING_FULL,
        NO_VEHICLE
    }
}
