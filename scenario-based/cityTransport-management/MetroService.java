public class MetroService implements TransportService {
    public String getService(){ return "Metro"; }
    public String[] getRoute(){
        return new String[] {"DelhiMetro - DwarkaNoida", "DelhiMetro - KashmereGate", "NoidaMetro - Sector51", "DelhiMetro - Samaypur"};
    }
    public double[] getFair(){
        return new double[] {50, 40, 35, 45};
    }
    public int[] getDepartureTime(){
        return new int[] {700, 800, 900, 730};
    }
}
