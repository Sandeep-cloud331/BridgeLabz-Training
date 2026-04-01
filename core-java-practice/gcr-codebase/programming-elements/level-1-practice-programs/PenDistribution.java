public class PenDistribution {
    public static void main(String[] args) {
        int pens=14;
        int students=3;
        int penForEachStudent=pens/students;
        int remainingPens=pens%students;
        System.out.println("The Pen per Student is "+penForEachStudent+" and the remaining pen not distributed is "+remainingPens);
    }
}
