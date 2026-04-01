import java.util.*;

public class UnionIntersection{
    public static void union(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        System.out.println(union);
    }

    public static void intersection(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        System.out.println(intersection);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter set 1 size: ");
        int n = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        
        System.out.println("Elements for set 1: ");
        for(int i = 0; i < n; i++){
            set.add(sc.nextInt());
        }


        System.out.println("Enter set 2 size: ");
        int m = sc.nextInt();

        Set<Integer> set2 = new HashSet<>();
        
        System.out.println("Elements for set 2: ");
        for(int i = 0; i < m; i++){
            set2.add(sc.nextInt());
        }

        union(set, set2);
        intersection(set, set2);
    }
}