package FoodDeliveryApp.models;

public class User {
    int id;
    String name;
    String address;
    Cart cart;

    public User(String name,String address){
        this.name=name;
        this.address=address;
        cart=new Cart();
    }

    public void addRestaurantToCart(Restaurant restaurant){
        cart.addRestaurant(restaurant);
    }

    public void addItemtoCart(MenuItem a){
        cart.addToCart(a);
    }

    public void checkout(){
        cart.checkout();
    }

    public Cart getCart(){
        return this.cart;
    }

    public String getName(){
        return this.name;
    }
}
