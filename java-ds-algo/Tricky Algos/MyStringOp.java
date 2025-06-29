import java.util.*;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;


public class MyStringOp {

    public static void main(String[] args) {
        // aabbbcca  =a2b3c2a1

        String s = "aabbbcca";
        String [] sArr = s.split("");

        Map<String, Long> count = Arrays.stream(sArr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Strrem<Str>
        System.out.println(count);


        // Map<String, Long> cnt =  Arrays.stream(sArr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        /** Using Nested For Loop */
        // chaAt[0] == charAt[1] => 2
        // charAt[1] == charAt[2] => 3

        // charAt[1] != charAt[2] => 
        // charAt[2] == charAt[3] => 
        /**
         * 0
         *  then compare with -> 1
         *              == constructionInProgress; break;
         *              != constructionFinished; generateReport reurn; break
         */
        StringBuilder stringWithCount = new StringBuilder();
        int countOfOccurance = 1;

        for (int i = 0; i < s.length(); i++) {
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) { // chance of indexOutOfBound -- add short ckt &&
                // keep building
                ++ countOfOccurance;
            } else {
                // terminate building
                stringWithCount.append(s.charAt(i));
                stringWithCount.append(countOfOccurance);
                countOfOccurance = 1; // reset
            }
        }

        System.out.println(stringWithCount);

    }

}


