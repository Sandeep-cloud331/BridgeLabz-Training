public class EVService implements TransportService {
    public String getService(){ return "Electric Vehicle"; }
    public String[] getRoute(){
        return new String[] {"Delhi EV Hub", "Agra EV Stand", "Lucknow EV Charge", "Noida EV Point"};
    }
    public double[] getFair(){
        return new double[] {15, 14, 16, 15};
    }
    public int[] getDepartureTime(){
        return new int[] {800, 900, 1000, 700};
    }
}
