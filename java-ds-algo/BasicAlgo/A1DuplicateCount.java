import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A1DuplicateCount {
    static List<Integer> myList = Arrays.asList(2,5,3,4,4,7,7,9,3,3);

    public static void main(String args[]) {
        Map<Integer, Integer> mp = new HashMap<>();
        Integer []arr = myList.toArray(new Integer[0]); // Object
        for (int x : arr) {
            if (mp.containsKey(x)) {
                mp.put(x, (mp.get(x) + 1));
            } else {
                mp.put(x, 1);
            }
        }
        System.out.println(mp);
    }
}
