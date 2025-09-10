package FoodDeliveryApp;

import java.util.*;

import FoodDeliveryApp.manager.RestaurantManager;
import FoodDeliveryApp.models.MenuItem;
import FoodDeliveryApp.models.Restaurant;
import FoodDeliveryApp.models.User;
import FoodDeliveryApp.models.Order;
import FoodDeliveryApp.models.DeliveryOrder;
import FoodDeliveryApp.strategies.PaymentStrategy;
import FoodDeliveryApp.strategies.UPIPaymentStrategy;
import FoodDeliveryApp.services.Notification;

public class App {

    public App() {
        initializeRestaurants();
    }

    private void initializeRestaurants() {
        System.out.println("[Init] Seeding sample restaurants and menus...");
        Restaurant restaurant1 = new Restaurant("Bikaner", "Delhi");
        restaurant1.addMenuItem(new MenuItem(1, "Chole Bhature", 120));
        restaurant1.addMenuItem(new MenuItem(2, "Samosa", 15));

        Restaurant restaurant2 = new Restaurant("Haldiram", "Kolkata");
        restaurant2.addMenuItem(new MenuItem(1, "Raj Kachori", 80));
        restaurant2.addMenuItem(new MenuItem(2, "Pav Bhaji", 100));
        restaurant2.addMenuItem(new MenuItem(3, "Dhokla", 50));

        Restaurant restaurant3 = new Restaurant("Saravana Bhavan", "Chennai");
        restaurant3.addMenuItem(new MenuItem(1, "Masala Dosa", 90));
        restaurant3.addMenuItem(new MenuItem(2, "Idli Vada", 60));
        restaurant3.addMenuItem(new MenuItem(3, "Filter Coffee", 30));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
        System.out.println("[Init] Restaurants loaded: 3\n");
    }

    ArrayList<Restaurant> searchRestaurants(String location) {
        System.out.println("[Search] Looking for restaurants in: " + location);
        ArrayList<Restaurant> result = RestaurantManager.getInstance().searchByLocation(location);
        System.out.println("[Search] Found: " + result.size());
        return result;
    }

    void selectRestaurant(User user, Restaurant restaurant){
        System.out.println("[Select] User " + user.getName() + " selected restaurant: " + restaurant.getName());
        user.addRestaurantToCart(restaurant);
    }

    void addToCart(User user, int itemCode){
        Restaurant restaurant = user.getCart().getRestaurant();
        if(restaurant==null){
            System.out.println("[Cart] Please select a restaurant first.");
            return;
        }
        for(MenuItem item : restaurant.getMenu()){
            if(item.getCode()==itemCode){
                user.addItemtoCart(item);
                System.out.println("[Cart] Added: " + item.getName() + " (₹" + item.getPrice() + ")");
                return;
            }
        }
        System.out.println("[Cart] Item with code " + itemCode + " not found in menu.");
    }

    void printUserCart(User user){
        System.out.println("\n[Cart] Items in cart:");
        System.out.println("------------------------------------");
        for(MenuItem item : user.getCart().getItems()){
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotal());
    }

    void checkout(User user){
        if(user.getCart().isEmpty()){
            System.out.println("[Checkout] Cart is empty.");
            return;
        }
        Order order = new DeliveryOrder();
        order.setRestaurant(user.getCart().getRestaurant());
        order.setItems(user.getCart().getItems());
        order.setUser(user);
        order.setTotal(user.getCart().getTotal());
        PaymentStrategy payment = new UPIPaymentStrategy("alice@upi");
        order.setPaymentStrategy(payment);
        System.out.println("[Checkout] Created order: " + order);
        boolean success = order.processPayment();
        if(success){
            System.out.println("[Checkout] Payment success.");
            new Notification().notify(order, user);
            user.getCart().clear();
        }else{
            System.out.println("[Checkout] Payment failed.");
        }
    }

    public void runDemo(){
        User user = new User("Alice", "Bangalore");
        ArrayList<Restaurant> delhiRestaurants = searchRestaurants("Delhi");
        if(!delhiRestaurants.isEmpty()){
            Restaurant chosen = delhiRestaurants.get(0);
            selectRestaurant(user, chosen);
            addToCart(user, 1);
            addToCart(user, 2);
            printUserCart(user);
            checkout(user);
        } else {
            System.out.println("[Search] No restaurants found for given location.");
        }
    }
}