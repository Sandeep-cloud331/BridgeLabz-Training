public interface TransportService{
    String getService();
    double[] getFair();
    String[] getRoute();
    int[] getDepartureTime();

    default void printServiceDetails(){
        if(this instanceof EmergencyService){
            System.out.println(getService() + " -> " + getRoute()[0] + " -> " + getDepartureTime()[0] + " -> " + getFair()[0]); 
        }
        else {
            double[] fare = getFair();
            String[] route = getRoute();
            int[] time = getDepartureTime();

            System.out.println(getService() + " : ");
            for(int i = 0; i < 4; i++){
                System.out.println(getService() + (i+1) + " Route -> " + route[i] + " Time -> " + time[i] + " Fare -> " + fare[i]);
            }
        }
    }
}