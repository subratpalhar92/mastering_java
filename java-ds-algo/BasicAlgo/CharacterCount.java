import java.text.Collator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CharacterCount {

    public static void main(String[] args) {
        /**
         * TO SEE THE GROUPING REPLACE THE LINES
         * 
         * Map<String, List<String>> finalCollections = Arrays.stream(arrOfStr)     // LINE A
         * =
         * .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));   // LINE Z
         */

        String str = "I am A java developer";
        String [] arrOfStr = str.split("");
        Map<String, Long> finalCollections = Arrays.stream(arrOfStr) // Stream<T>       // LINE A
            .map(strr -> strr.toUpperCase())
            .map(strrr -> strrr.replace(" ", "Space"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));    // LINE Z

        TreeMap<String, Long> sortedMap = new TreeMap<>(finalCollections);
        System.out.println(sortedMap);

    }

}

