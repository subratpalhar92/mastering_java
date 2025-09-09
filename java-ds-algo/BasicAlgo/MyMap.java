import java.util.HashMap;
import java.util.Map;

public class MyMap {

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("Apple", 10);
        myMap.put("Orange", 5);
        myMap.put("Banana", 8);

        System.out.println("Key-Value pairs in the map:");
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}






