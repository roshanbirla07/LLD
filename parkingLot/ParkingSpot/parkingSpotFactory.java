package ParkingSpot;

import ParkingSpot.ParkingStrategy.findNearEntrance;
import Vehicle.Vehicle;

public class parkingSpotFactory {
     
    public static parkingSpotManager getPSManager(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case "TWO_WHEELER":
                return new TWO_WHEELER_PSManager(null, new findNearEntrance());
            case "FOUR_WHEELER":
                return new FOUR_WHEELER_PSManager(null, new findNearEntrance());
            default:
                return null;
        }
    }
}
