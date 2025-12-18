public class ProfitAndLoss {
    public static void main(String[] args) {
        int costPrice=129;
        int sellingPrice=191;
        int profit=sellingPrice-costPrice;
        double profitPercentage=((double) profit /costPrice)*100;
        System.out.println("Profit is of "+profit+" and profit percentage is "+profitPercentage+"%");
    }
}
