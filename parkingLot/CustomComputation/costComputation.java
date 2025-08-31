package CustomComputation;

import CustomComputation.PriceStrategy.priceStrategy;
import Ticket.Ticket;

public class costComputation {
    
    priceStrategy psObj;
    Ticket tkt;

    costComputation(priceStrategy obj,Ticket ticket){
        this.psObj=obj;
        this.tkt=ticket;
    }

    int price(Ticket ticket){
        return psObj.price(ticket);
    }
}
