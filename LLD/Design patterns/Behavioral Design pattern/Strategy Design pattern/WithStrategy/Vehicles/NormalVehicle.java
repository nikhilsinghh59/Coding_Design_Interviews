package WithStrategy.Vehicles;
import WithStrategy.DriveStrategy.*;

public class NormalVehicle extends Vehicle {
    public NormalVehicle(){
        super(new NormalDriveStrategy());
    }
}
