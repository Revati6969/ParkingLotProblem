package service;

import exception.ParkingLotException;
import observer.Observer;
import observer.Owner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ParkingLotMain {

    Object vehicle;
    LinkedHashMap<String, Object> parkingLot = new LinkedHashMap<String, Object>();
    private List<Observer> observableList = new ArrayList<>();
    Owner owner = new Owner();
    private String isFull;

    public void addObserver(Observer observable) {
        this.observableList.add(observable);
    }

    public void setStatus(String isFull) {
        this.isFull = isFull;
        for (Observer observable : this.observableList) {
            observable.update(this.isFull);
        }
    }

    //PARK VEHICLE
    public String parkVehicle(VehiclesPojo vehicle) throws ParkingLotException {
        if (parkingLot.size()%2==0 && parkingLot.size() != 0) {
            parkingLot = null;
            throw new ParkingLotException("Parking lot is full", ParkingLotException.ExceptionType.PARKING_FULL);
        }
        this.vehicle = vehicle;
        parkingLot.put(vehicle.getVehicleNumber(), vehicle);
        return null;
    }

    //CHECK VEHICLE IS PARKED OR NOT
    public boolean isVehiclePark(Object vehicle) {
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public boolean unParkVehicle(VehiclesPojo vehicle) throws ParkingLotException {
        if (vehicle == null) return false;
        if(this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            parkingLot.remove(vehicle.getVehicleNumber());
            return true;
        }
        throw new ParkingLotException("No Vehicle found", ParkingLotException.ExceptionType.NO_VEHICLE);
    }
}
