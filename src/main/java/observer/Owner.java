package observer;

public class Owner implements Observer {

    private String parkingSlotFullOrNot;

    @Override
    public void update(Object status) {
        this.setParkingSlotFullOrNot((String) status);

    }

    // setter method
    public void setParkingSlotFullOrNot(String parkingSlotFullOrNot) {
        this.parkingSlotFullOrNot = parkingSlotFullOrNot;
    }

    // getter method
    public String getParkingSlotFullOrNot() {
        return parkingSlotFullOrNot;
    }
}
