public class DayOfWeek {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java DayOfWeek <month> <day> <year>");
            return;
        }
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        // Adjust month and year for Jan and Feb
        if (m < 3) {
            m += 12;
            y--;
        }

        int k = y % 100;   // Year of the century
        int j = y / 100;   // Century

        // Zeller's Congruence (Gregorian)
        int h = (d + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        /*
        Where:
            - h = day of week (0=Sat, 1=Sun, ..., 6=Fri)
            - d = day of month
            - m = month (3=March, 4=April, ..., 14=Feb)
            - y = year
            - k = y % 100 (year of century)
            - j = y / 100 (century)

        */

        // Zeller's mapping:
        // 0=Saturday, 1=Sunday, 2=Monday, ..., 6=Friday
        System.out.println(h);
    }
}
