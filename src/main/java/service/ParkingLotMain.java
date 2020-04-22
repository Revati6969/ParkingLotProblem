package service;

import exception.ParkingLotException;

public class ParkingLotMain {

    Object vehicle;

    //PARK VEHICLE
    public void parkVehicle(Object vehicle) throws ParkingLotException {
        if(this.vehicle != null)
            throw new ParkingLotException("Parking is full", ParkingLotException.ExceptionType.PARKING_FULL);
        this.vehicle = vehicle;
    }

    //CHECK VEHICLE IS PARKED OR NOT
    public boolean isVehiclePark(Object vehicle) {
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public boolean unParkVehicle(Object vehicle) throws ParkingLotException {
        if(this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        throw new ParkingLotException("No Vehicle found", ParkingLotException.ExceptionType.NO_VEHICLE);
    }
}
