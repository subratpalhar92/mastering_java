import java.util.*;
import java.util.stream.Collectors;

public class ArrayOfArray {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("bat", "tab", "eat", "tea", "tan", "nat");

        Map<String, List<String>> arrayOfArray = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            /**
             * The computeIfAbsent method internally checks if the 'key' exists
             * Only if it doesn't exist does computeIfAbsent invoke this lambda function
             * To generate the new ArrayList to be associated with that key
             *
             * computeIfAbsent(key, mappingFunction) is to either
             *  - Return existing value associated with the 'key' if already present in Map - arrayOfArray
             *  - If 'key' is not present, compute a new value using provided mappingFunction,
             *    put this new value into the Map under the given key,
             *    and then return the newly computed value
             * 
             * The key here is that the mappingFunction "(k -> new ArrayList<>()" is only executed if the key is absent
             * This is a form of lazy evaluation
             * 
             * Check Map interface default method
             * default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
             */
            arrayOfArray.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }


        System.out.println(arrayOfArray.values());
    }
}



/***
 * I/P: ["bat", "tab", "eat", "tea", "tan", "nat"]
 * O/P: [[bat, tab], [eat, tea], [tan, nat]]
 * 
 * return words.stream().collect(Collectors.groupingBy(word -> {
 *          char[] chars = word.toCharArray();
 *          Arrays.sort(chars);
 *          return new String(chars);
 * })).values().stream().toList();
 */
