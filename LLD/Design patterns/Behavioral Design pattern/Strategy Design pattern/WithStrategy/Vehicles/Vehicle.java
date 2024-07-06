package WithStrategy.Vehicles;

import WithStrategy.DriveStrategy.DriveStrategy;

public class Vehicle{
    private DriveStrategy d;

    Vehicle(DriveStrategy d){
        this.d = d;
    }

    public void drive(){
        d.drive();
    }
}
