package FoodDeliveryApp.models;

import java.util.ArrayList;


import FoodDeliveryApp.strategies.PaymentStrategy;

public abstract class Order {
    public static int nextOrderId=0;
    int orderId;
    Restaurant restaurant;
    ArrayList<MenuItem>items;
    User user;
    double total;
    PaymentStrategy paymentStrategy;
    String scheduled;


    Order(){
        restaurant=null;
        user=null;
        paymentStrategy=null;
        scheduled=null;
        total = 0.0;
        scheduled = "";
        orderId = ++nextOrderId;

    }

    public boolean processPayment() {
        if (this.paymentStrategy !=null) {
            paymentStrategy.pay(total);
            return true;
        } else {
            System.out.println("Please choose a payment mode first" );
            return false;
        }
    }
    public abstract String getType();

    public void setPaymentStrategy(PaymentStrategy p) {
        paymentStrategy = p;
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public void setItems(ArrayList<MenuItem> items){
        this.items = items;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public int getOrderId(){ return this.orderId; }

    @Override
    public String toString(){
        String restaurantName = (restaurant!=null ? restaurant.getName() : "-");
        return "Order{" +
               "id=" + orderId +
               ", type=" + getType() +
               ", user=" + (user!=null ? user.getName() : "-") +
               ", restaurant=" + restaurantName +
               ", total=" + total +
               '}';
    }

}

