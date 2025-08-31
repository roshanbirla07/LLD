package ParkingSpot;
import java.util.List;

import ParkingSpot.ParkingStrategy.parkingStrategy;
import Vehicle.Vehicle;
public class parkingSpotManager {
    
   private List<parkingSpot> parkingSpots;
    private parkingStrategy parkingStrategy;
    
    public parkingSpotManager(List<parkingSpot> parkingSpots , parkingStrategy Strategy){
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = parkingStrategy;

    }


    public parkingSpot findParkingSpot(Vehicle vehicle , int GateNo){
        return this.parkingStrategy.findParkingSpot(vehicle, GateNo);
    }

  private void addParkingSpace(parkingSpot spot){
        parkingSpots.add(spot);
    }

   private void removeParkingSpace(parkingSpot spot){
        parkingSpots.remove(spot);
    }
    boolean parkVehicle(Vehicle vehicle , int GateNo){
        parkingSpot spot = findParkingSpot(vehicle, GateNo);
        if(spot != null){
            spot.addVehicle(vehicle);
            return true;
        }
        return false;
    }

    boolean removeVehicle(Vehicle vehicle){
        return true;
    }

}


