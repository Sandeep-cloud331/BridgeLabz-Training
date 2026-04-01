import java.util.*;

public class EqualSets{
    public static boolean equal(Set<Integer> set1, Set<Integer> set2){
      if(set1.size() != set2.size()) return false;

      for(int i = 0; i < set1.size(); i++){
        if(!set1.containsAll(set2)){
            return false;
        }
      }

      return true;
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

        System.out.println(equal(set, set2));
    }
}