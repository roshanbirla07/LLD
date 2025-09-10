package FoodDeliveryApp.models;

public class MenuItem {
    int code;
    String name;
    double price;

   public MenuItem(int code,String name , double price){
        this.code=code;
        this.name=name;
        this.price=price;
    }

  public String getName(){return this.name;}
  public void setName(String name) { this.name=name;}

  public double getPrice(){
    return this.price;
  }

  public void setPrice(double price){
    this.price=price;
  }

  public int getCode(){
    return this.code;
  }

}
