package FoodDeliveryApp.models;

import java.util.ArrayList;

public class Cart {
     Restaurant restaurant;
     ArrayList<MenuItem>menu;
     int total;

     Cart(){
        menu=new ArrayList<>();
        total=0;
     };

     public void addToCart(MenuItem a){
        
        
        total+=a.getPrice();
        menu.add(a);

     }

     public void addRestaurant(Restaurant rs){
        this.restaurant=rs;
     }

     public void checkout(){};

     public ArrayList<MenuItem> getItems(){
        return this.menu;
     }

     public Restaurant getRestaurant(){
        return this.restaurant;
     }

     public int getTotal(){
        return this.total;
     }

     public boolean isEmpty(){
        return menu.isEmpty();
     }

     public void clear(){
        menu.clear();
        total=0;
     }
}
