import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hello {
    public static void main(String[] args) {
        char []englishAlphabests = {'A','B', 'C', 'D','E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String hello = "HELLO";

        Map<Character, Boolean> existing = new HashMap<>();
        char []x = hello.toCharArray();
        for (char y: x) {
            // existing.put(String.valueOf(y), true);
            // existing.put(Character.toString(y), true);
            existing.put(y, true);
        }

        for (char z: englishAlphabests) {
            if (!existing.containsKey(z)) {
                System.out.println(z);
            }
        }

        // Predicate<String> p = v -> englishAlphabests.in(v)
        // Arrays.stream(englishAlphabests).test(p).collect(Collectors.toList());

    }
}
