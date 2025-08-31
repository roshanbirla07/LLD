package Ticket;

import java.time.LocalDateTime;
import ParkingSpot.parkingSpot;
import Vehicle.Vehicle;

public class Ticket {
    
    LocalDateTime entryTime;
    Vehicle vehicle;
    parkingSpot spot;

    Ticket(Vehicle vehicle , parkingSpot spot){
        this.entryTime=LocalDateTime.now();
        this.vehicle=vehicle;
        this.spot=spot;

    }
}
