package FoodDeliveryApp.factory;

import java.util.ArrayList;

import FoodDeliveryApp.models.MenuItem;
import FoodDeliveryApp.models.Restaurant;
import FoodDeliveryApp.models.User;
import FoodDeliveryApp.strategies.PaymentStrategy;

public class NowOrder extends OrderFactory {
    @Override
    public void createOrder(Restaurant restaurant, ArrayList<MenuItem> items, User user, double total,
            PaymentStrategy paymentStrategy, String scheduled) {
        
            
        
    }
}
