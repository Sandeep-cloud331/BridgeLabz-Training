public class Passenger {
    private String passergerName;
    private double fare;
    private String route;
    public TransportService transportType;

    public Passenger(String name, double fare, String route, TransportService type){
        this.passergerName = name;
        this.fare = fare;
        this.route = route;
        this.transportType = type;
    }

    public String getName(){ return passergerName;}
    public double getFare(){ return fare; }
    public String getRoute(){ return route; }
    public TransportService getType(){ return transportType; }
}
