package Design_patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.WithStrategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive(){
        System.out.println("Normal drive strategy used");
    }
}