package ParkingSpot.ParkingStrategy;

import ParkingSpot.parkingSpot;
import Vehicle.Vehicle;

public interface parkingStrategy {
    
    parkingSpot findParkingSpot(Vehicle vehicle, int GateNo);
}
