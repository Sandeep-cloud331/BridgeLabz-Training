import java.util.Scanner;
public class FriendStats {

    // method to find tthe youngest among three friends
    public static int findYoungest(int[] ages) {
        int min = ages[0];
        for (int age : ages) min = Math.min(min, age);
        return min;
    }

    // method for finding tallest among three freinds
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int height : heights) max = Math.max(max, height);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // created array for 3 friends
        int[] ages = new int[3];
        int[] heights = new int[3];

        // user input for ages and heights in array
        for (int i = 0; i < 3; i++) ages[i] = sc.nextInt();
        for (int i = 0; i < 3; i++) heights[i] = sc.nextInt();

        // output the results
        System.out.println("Youngest age: " + findYoungest(ages));
        System.out.println("Tallest height: " + findTallest(heights));

        sc.close();
    }
}
