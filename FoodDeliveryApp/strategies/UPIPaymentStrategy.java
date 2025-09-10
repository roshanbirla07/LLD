package FoodDeliveryApp.strategies;


public class UPIPaymentStrategy extends PaymentStrategy {
    String upiNumber;
    public UPIPaymentStrategy(String upiNumber ){
        this.upiNumber=upiNumber;
    }
    @Override
    public void pay(double price) {
        
        System.out.println("[Payment] UPI " + this.upiNumber + ", amount ₹" + price);
        
    }
}
