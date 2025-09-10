package FoodDeliveryApp.factory;

import java.util.ArrayList;

import FoodDeliveryApp.models.MenuItem;
import FoodDeliveryApp.models.Restaurant;
import FoodDeliveryApp.models.User;
import FoodDeliveryApp.strategies.PaymentStrategy;

public abstract class OrderFactory {
    
    public abstract void createOrder( Restaurant restaurant,ArrayList<MenuItem>items,User user, double total,PaymentStrategy paymentStrategy,String scheduled);
}
