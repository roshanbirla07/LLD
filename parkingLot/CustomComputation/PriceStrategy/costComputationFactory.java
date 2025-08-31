package CustomComputation.PriceStrategy;

import CustomComputation.TWO_WHEELER_CostCumputation;
import CustomComputation.costComputation;
import Ticket.Ticket;
import Vehicle.Vehicle;

public class costComputationFactory {
    
    public static costComputation getCostComputation(Ticket tkt ,Vehicle vehicle){
        switch (vehicle.getVehicleType()) {
            case "TWO_WHEELER":
                return new TWO_WHEELER_CostCumputation(new hourlyPriceStrateg() , tkt);
            
            default:
                return null;
        }
    }
}
