import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterStream {
    public static void main(String[] args) {

        // IntStream.rangeClosed('A', 'Z').mapToObj(c -> (char) c).collect(Collectors.toList());

        String alphabet = IntStream.rangeClosed('A', 'Z')
            .mapToObj(c -> (char) c).map(String::valueOf)       /** Required Explicit - Robust */
            .collect(Collectors.joining(""));

        // char[] x = alphabet.toCharArray();   /** PROBLEM WITH CHAR !! Arrays.stream(y) */

        String [] alphabets = alphabet.split("");


        Arrays.stream(alphabets)
            .filter(    str -> ! ("HELLO".contains(str))    )
            .forEach(System.out::print);
        System.out.println();
    }
}