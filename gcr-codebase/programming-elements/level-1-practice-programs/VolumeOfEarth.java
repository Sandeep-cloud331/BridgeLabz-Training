import static java.lang.Math.PI;

public class VolumeOfEarth {
    public static void main(String[] args) {
        int radiusOfEarth=6378;
        double radiusOfEarthInMiles=6378*0.6;
        //formula of volume=(4/3)*pi *r^3
        double volume=(4.0/3.0)*PI*Math.pow(radiusOfEarth,3);
        double volumeInMiles=(4.0/3.0)*PI*Math.pow(radiusOfEarthInMiles,3);
        System.out.println("The volume of earth in cubic kilometers is "+volume+" and cubic miles is "+volumeInMiles);
    }
}
