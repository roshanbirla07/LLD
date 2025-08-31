package ParkingSpot;
import java.util.*;

import ParkingSpot.ParkingStrategy.parkingStrategy;

public class TWO_WHEELER_PSManager extends parkingSpotManager {
    
    List<parkingSpot> l;
    parkingStrategy PS;

    TWO_WHEELER_PSManager(List<parkingSpot> l, parkingStrategy PS) {
        super(l, PS);
        this.l = l;
        this.PS = PS;
    }
}
