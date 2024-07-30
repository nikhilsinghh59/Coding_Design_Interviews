package Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy;
import Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.DriveStrategy.DriveStrategy;
import Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.DriveStrategy.NormalDriveStrategy;
import Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.Vehicles.NormalVehicle;
import Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.Vehicles.Vehicle;

//import WithStrategy.Vehicles.NormalVehicle;

public class Main {
    public static void main(String args[]) {
        DriveStrategy d = new NormalDriveStrategy();
        d.drive();

        Vehicle v = new NormalVehicle();
        v.drive();
    }
}








/*
 * 
 * 
 * 
 */