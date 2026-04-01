public class TaxiService implements TransportService {
    public String getService(){ return "Taxi"; }
    public String[] getRoute(){
        return new String[] {"Delhi-Gurgaon", "Noida-KarolBagh", "Andheri-BKC", "Bandra-NaviMumbai"};
    }
    public double[] getFair(){
        return new double[] {650, 750, 500.0, 900};
    }
    public int[] getDepartureTime(){
        return new int[] {800, 800, 800, 830};
    }
}
