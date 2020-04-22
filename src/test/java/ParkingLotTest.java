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

    @Test
    public void givenVehicle_WhenUnPark_ThenTrue() throws ParkingLotException {
        parkingLotMain.parkVehicle(vehicle);
        boolean result=parkingLotMain.unParkVehicle(vehicle);
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenVehicle_WhenAlreadyUnPark_ThenFalse(){
        try {
            parkingLotMain.parkVehicle(vehicle);
            boolean result=parkingLotMain.unParkVehicle(new Object());
            Assert.assertEquals(false,result);
        } catch (ParkingLotException e) {
           Assert.assertEquals("No Vehicle found", e.getMessage());
        }
    }


}
