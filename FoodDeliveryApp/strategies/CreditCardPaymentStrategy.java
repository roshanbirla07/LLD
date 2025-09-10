package FoodDeliveryApp.strategies;

public class CreditCardPaymentStrategy extends PaymentStrategy {
    
    String cardNumber;
    public CreditCardPaymentStrategy(String cardNumber){
        this.cardNumber=cardNumber;
    }

    @Override
    public void pay(double price){
        System.out.println("[Payment] Card " + this.cardNumber + ", amount ₹" + price);

    }
}
