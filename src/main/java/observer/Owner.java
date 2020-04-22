package observer;

public class Owner implements Observer {

    private String parkingSlotFullOrNot;

    @Override
    public void update(Object status) {
        this.setParkingSlotFullOrNot((String) status);

    }

    public void setParkingSlotFullOrNot(String parkingSlotFullOrNot) {
        this.parkingSlotFullOrNot = parkingSlotFullOrNot;
    }

    public String getParkingSlotFullOrNot() {
        return parkingSlotFullOrNot;
    }
}
