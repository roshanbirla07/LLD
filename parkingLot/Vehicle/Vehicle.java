package Vehicle;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    
    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
    
    // Getters and setters
    public String getVehicleNumber() { 
        return vehicleNumber; 
    }
    public String getVehicleType() { 
        return vehicleType; 
    }
    
   
}
