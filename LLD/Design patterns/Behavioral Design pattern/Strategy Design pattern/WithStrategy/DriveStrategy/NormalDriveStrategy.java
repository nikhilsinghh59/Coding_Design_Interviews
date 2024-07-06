package WithStrategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive(){
        System.out.println("Normal drive strategy used");
    }
}