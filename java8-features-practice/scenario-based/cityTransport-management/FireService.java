public class FireService implements TransportService, EmergencyService{
    public String getService(){ return "Fire Brigade";}
    public String[] getRoute(){ return new String[] {"Emergency Route"}; }
    public double[] getFair(){ return  new double[] {0};}
    public int[] getDepartureTime(){ return new int[] {0}; }
}

class AmbulanceService implements TransportService, EmergencyService{
    public String getService(){ return "Ambulance";}
    public String[] getRoute(){ return new String[] {"Emergency Route"}; }
    public double[] getFair(){ return  new double[] {0};}
    public int[] getDepartureTime(){ return new int[] {0}; }
}

class PoliceService implements TransportService, EmergencyService{
    public String getService(){ return "Police";}
    public String[] getRoute(){ return new String[] {"Emergency Route"}; }
    public double[] getFair(){ return  new double[] {0};}
    public int[] getDepartureTime(){ return new int[] {0}; }
}

