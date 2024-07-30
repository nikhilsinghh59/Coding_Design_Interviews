package Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.Vehicles;

import Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.DriveStrategy.DriveStrategy;

public class Vehicle{
    private DriveStrategy d;

    Vehicle(DriveStrategy d){
        this.d = d;
    }

    public void drive(){
        d.drive();
    }
}
