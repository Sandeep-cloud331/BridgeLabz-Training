import java.util.*;

public class InvertMap{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);

        Map<Integer, List<String>> newMap = new HashMap<>();
        
        for (String key : map.keySet()) {
            int value = map.get(key);

            if (!newMap.containsKey(value)) {
                newMap.put(value, new ArrayList<>());
            }

            newMap.get(value).add(key);
        }
        
        System.out.println(newMap);
    }
}