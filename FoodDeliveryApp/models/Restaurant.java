package FoodDeliveryApp.models;
import java.util.*;

public class Restaurant {
    public static int restaurantId=0;
    int id;
    String name;
    String address;
    ArrayList<MenuItem>menu;

    public Restaurant(String name , String address){
        this.id=restaurantId++;
        this.name=name;
        this.address=address;
        menu=new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public void addMenuItem(MenuItem a){
        menu.add(a);
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public ArrayList<MenuItem> getMenu(){
        return this.menu;
    }

}
