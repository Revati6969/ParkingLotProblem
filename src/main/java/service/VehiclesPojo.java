package service;

public class VehiclesPojo {

    private String vehicleName;
    private String vehicleNumber;

    public void setVehicleName(String vehicaleName) {
        this.vehicleName = vehicaleName;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicaleName() {
        return vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public String toString() {
        return "VehiclePOJO{" +
                "vehicaleName='" + vehicleName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
