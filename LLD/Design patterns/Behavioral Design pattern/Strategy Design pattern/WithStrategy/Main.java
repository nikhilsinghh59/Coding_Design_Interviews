package WithStrategy;
import WithStrategy.DriveStrategy.DriveStrategy;
import WithStrategy.DriveStrategy.NormalDriveStrategy;
import WithStrategy.Vehicles.*;
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