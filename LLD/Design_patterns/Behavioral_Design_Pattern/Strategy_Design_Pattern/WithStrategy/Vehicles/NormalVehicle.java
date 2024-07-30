package Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.Vehicles;
import Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.DriveStrategy.NormalDriveStrategy;


public class NormalVehicle extends Vehicle {
    public NormalVehicle(){
        super(new NormalDriveStrategy());
    }
}
