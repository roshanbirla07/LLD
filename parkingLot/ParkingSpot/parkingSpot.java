package ParkingSpot;

import Vehicle.Vehicle;

public class parkingSpot {
    private int spotNumber;
    private Vehicle vehicle; 
    private boolean isOccupied;

    public parkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
