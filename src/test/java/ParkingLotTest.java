import exception.ParkingLotException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ParkingLotMain;

public class ParkingLotTest {
    ParkingLotMain parkingLotMain = null;
    Object vehicle = null;

    @Before
    public void setUp() {
        vehicle = new Object();
        parkingLotMain = new ParkingLotMain();
    }

    @Test
    public void givenVehicle_WhenParked_ReturnTrue() throws ParkingLotException {
        parkingLotMain.parkVehicle(vehicle);
        boolean result = parkingLotMain.isVehiclePark(vehicle);
        Assert.assertTrue(result);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldThrowException() {
        try {
            parkingLotMain.parkVehicle(vehicle);
            parkingLotMain.parkVehicle(new Object());
        } catch (ParkingLotException e) {
          Assert.assertEquals("Parking is full", e.getMessage());
        }
    }
}
