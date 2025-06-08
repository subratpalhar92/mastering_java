import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatingChar {

    public static void main(String[] args) {
        String s = "Hello Hi";

        String [] ss = s.split("");

        Map<String, Long> countMap = Arrays.stream(ss).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Optional<String> os = countMap.keySet().stream().filter((key) -> { if (countMap.get(key) > 1) {return true;} else {return false;} }).findFirst();
        if( os.isPresent() ) {
            System.out.println(os.get());
        }
    }
}
