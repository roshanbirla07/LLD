package FoodDeliveryApp.models;

public class DeliveryOrder extends Order {
    
    String userAddress;

    public DeliveryOrder(){
        userAddress="";
    }
    
    @Override
    public String getType() {
        return "Delivery";
    }

    public void setUserAddress(String addr) {
        this.userAddress = addr;
    }

    String getUserAddress() {
        return this.userAddress;
    }
}
