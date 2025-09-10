package FoodDeliveryApp.services;

import FoodDeliveryApp.models.Order;
import FoodDeliveryApp.models.User;

public class Notification {
    
    public void notify(Order order , User user){
        System.out.println("[Notify] Order placed: " + order + ", for user: " + (user!=null?user.getName():"-"));
    }
}
