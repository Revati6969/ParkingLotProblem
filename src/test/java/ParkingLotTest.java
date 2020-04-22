import exception.ParkingLotException;
import observer.AirportSecurity;
import observer.Owner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ParkingLotMain;
import service.VehiclesPojo;

public class ParkingLotTest {
    ParkingLotMain parkingLotMain = null;
    VehiclesPojo vehicle = null;
    Owner owner = null;
    AirportSecurity security = null;


    @Before
    public void setUp() {
        vehicle = null;
        parkingLotMain = new ParkingLotMain();
        owner = new Owner();
        security = new AirportSecurity();
    }

    @Test
    public void givenVehicle_WhenParked_ReturnTrue() throws ParkingLotException {
        vehicle.setVehicleName("abc");
        vehicle.setVehicleNumber("11");
        parkingLotMain.parkVehicle(vehicle);
        boolean result = parkingLotMain.isVehiclePark(vehicle);
        Assert.assertTrue(result);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldThrowException() {
        try {
            parkingLotMain.parkVehicle(vehicle);
            parkingLotMain.parkVehicle(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking is full", e.getMessage());
        }
    }

    @Test
    public void givenVehicle_WhenUnPark_ThenTrue() throws ParkingLotException {
        parkingLotMain.parkVehicle(vehicle);
        boolean result = parkingLotMain.unParkVehicle(vehicle);
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenParkingLot_WhenFull_ThenReturnTrue() {
        try {
            VehiclesPojo vehicle = new VehiclesPojo();
            vehicle.setVehicleName("abc");
            vehicle.setVehicleNumber("11");
            parkingLotMain.parkVehicle(vehicle);
            vehicle.setVehicleName("abc");
            vehicle.setVehicleNumber("12");
            parkingLotMain.parkVehicle(vehicle);
            parkingLotMain.parkVehicle(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is full", e.getMessage());
        }
    }

    @Test
    public void givenParkingLotIsFull_WhenInformOwner_ThenReturnTrue() {
        try {
            parkingLotMain.addObserver(owner);
            VehiclesPojo vehicle1 = new VehiclesPojo();
            vehicle1.setVehicleName("abc");
            vehicle1.setVehicleNumber("45");
            parkingLotMain.parkVehicle(vehicle1);
            VehiclesPojo vehicle2 = new VehiclesPojo();
            vehicle2.setVehicleName("abc");
            vehicle2.setVehicleNumber("47");
            parkingLotMain.parkVehicle(vehicle2);
            vehicle.setVehicleName("abc");
            vehicle.setVehicleNumber("48");
            parkingLotMain.parkVehicle(vehicle);
            Assert.assertEquals("Full Lot 1", owner.getParkingSlotFullOrNot());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingLotIsFull_WhenInformAirportSecurity_ThenReturnTrue() {
        try {
            parkingLotMain.addObserver(security);
            VehiclesPojo vehicle1 = new VehiclesPojo();
            vehicle1.setVehicleName("abc");
            vehicle1.setVehicleNumber("45");
            parkingLotMain.parkVehicle(vehicle1);
            VehiclesPojo vehicle2 = new VehiclesPojo();
            vehicle2.setVehicleName("abc");
            vehicle2.setVehicleNumber("47");
            parkingLotMain.parkVehicle(vehicle2);
            vehicle.setVehicleName("abc");
            vehicle.setVehicleNumber("48");
            parkingLotMain.parkVehicle(vehicle);
            Assert.assertEquals("Full Lot 1", security.getParkingSlotFullOrNot());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
