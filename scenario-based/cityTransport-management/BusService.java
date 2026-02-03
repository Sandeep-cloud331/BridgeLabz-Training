public class BusService implements TransportService {
    public String getService(){ return "Bus"; }
    public String[] getRoute(){
        return new String[] {"Delhi-Agra", "Agra-Jaipur", "Lucknow-Varanasi", "Mumbai-Pune"};
    }
    public double[] getFair(){
        return new double[] {450.0, 550.0, 350.0, 300.0};
    }
    public int[] getDepartureTime(){
        return new int[] {800, 700, 900, 630};
    }
}
