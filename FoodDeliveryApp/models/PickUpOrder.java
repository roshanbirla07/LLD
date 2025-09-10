package FoodDeliveryApp.models;

public class PickUpOrder extends Order{
    
    String restaurantAddress;

    PickUpOrder(){
        restaurantAddress="";
    }

    @Override
    public String getType() {
        return "Pickup_Order";
    }

    //getter-setter
}
