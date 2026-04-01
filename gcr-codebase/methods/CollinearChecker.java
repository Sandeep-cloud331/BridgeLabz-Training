public class CollinearChecker {

    // method to find is collinear or not
    public static boolean isCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1)*(x3 - x2) == (y3 - y2)*(x2 - x1);
    }

    // method to find collinear by area
    public static boolean isCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2)) == 0;
    }

    public static void main(String[] args) {

        // output
        System.out.println(isCollinearBySlope(2,4,4,6,6,8));
        System.out.println(isCollinearByArea(2,4,4,6,6,8));
    }
}
