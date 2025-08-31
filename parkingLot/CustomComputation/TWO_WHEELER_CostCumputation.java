package CustomComputation;

import CustomComputation.PriceStrategy.priceStrategy;
import Ticket.Ticket;

public class TWO_WHEELER_CostCumputation extends costComputation{
    priceStrategy p;
    Ticket t;
    public TWO_WHEELER_CostCumputation(priceStrategy p, Ticket t) {
        super(p, t);
        this.p = p;
        this.t = t;
    }
}
