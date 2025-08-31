package EntranceGate;

import ParkingSpot.parkingSpot;
import ParkingSpot.parkingSpotFactory;
import ParkingSpot.parkingSpotManager;
import Ticket.Ticket;
import Vehicle.Vehicle;
public class entranceGate {
    
    parkingSpotFactory psFactory=new parkingSpotFactory();
    parkingSpotManager psManager;
    Ticket ticket;

    entranceGate(Vehicle vehicle){
        this.psManager=psFactory.getPSManager(vehicle);

    }



    parkingSpot findParkingSpot(Vehicle vehicle,int GateNo){
        return psManager.findParkingSpot( vehicle,GateNo);
    }

    //Book Spot
    
    //Generate ticket


}
