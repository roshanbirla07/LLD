package FoodDeliveryApp.manager;

import java.util.ArrayList;

import FoodDeliveryApp.models.Restaurant;

public class RestaurantManager {
     
    ArrayList<Restaurant>restaurants;
    private static RestaurantManager instance;

    private RestaurantManager(){
        restaurants = new ArrayList<>();
    }


    public static RestaurantManager getInstance(){

        if(instance==null){
            instance=new RestaurantManager();
        }

        return instance;
    }

    public ArrayList<Restaurant> searchByLocation (String location){

        ArrayList<Restaurant>result=new ArrayList<>();
        
        for(Restaurant r : restaurants){
            if(r.getAddress().equalsIgnoreCase(location)){
                result.add(r);
            }
        }
        return result;
    }

    public void addRestaurant(Restaurant rs){
        restaurants.add(rs);
    }

    public void removeRestaurant(int id){
        
        restaurants.removeIf(r -> r.getId() == id);
    }

}
