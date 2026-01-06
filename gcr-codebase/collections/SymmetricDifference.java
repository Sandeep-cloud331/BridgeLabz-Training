import java.util.*;

public class SymmetricDifference{
    public static void difference(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> difference = new HashSet<>(set1);

        difference.addAll(set2);        
        Set<Integer> temp = new HashSet<>(set1);
        temp.retainAll(set2);       
        difference.removeAll(temp);     

        System.out.println(difference);
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

        difference(set, set2);
        
    }
}