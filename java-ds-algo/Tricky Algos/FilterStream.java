import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterStream {
    public static void main(String[] args) {

        /**
         * IntStream.rangeClosed('A', 'Z').mapToObj(c -> (char) c).collect(Collectors.toList());
         * Collectors.toList() Works But Won't works with Collectors.joining()
         * So .map(String::valueOf) required
         * 
         * char[] x = alphabet.toCharArray();   // PROBLEM WITH CHAR !! Arrays.stream(y) 
         * Arrays.stream(x);    // HAVE PROBLEM WITH CHAR STREAM
         * 
         * ALSO STUDY "CharSequence" Interface In Java
         */


        String alphabet = IntStream.rangeClosed('A', 'Z')
            .mapToObj(c -> (char) c)
            .map(String::valueOf)       /** Required Explicit - Robust */
            .collect(Collectors.joining(""));


        String [] alphabets = alphabet.split("");


        Arrays.stream(alphabets)
            .filter(    str -> ! ("HELLO".contains(str))    )
            .forEach(System.out::print);
        System.out.println();
    }

}

