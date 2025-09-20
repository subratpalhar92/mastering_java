import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringSpaceEveryThree {


    public static String insertSpaceEveryThree(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        AtomicInteger counter = new AtomicInteger(0);

        return IntStream.range(0, input.length())
                .mapToObj(i -> String.valueOf(input.charAt(i)))
                // .collect(Collectors.joining())
                // .chars() // Resulting string back to an IntStream of character codes
                // .boxed() // Box the IntStream to a Stream of Character objects
                // .collect(Collectors.groupingBy(i -> i / 3)) // Group characters into lists of 3
                .collect(Collectors.groupingBy(item -> counter.getAndIncrement() / 3)) /** /3 => Zero or Non-Zero */

                .values() // IMPORTANT
                .stream()
                // .peek(System.out::println)

                // Join each group back into a string
                // .map( group -> group.stream().map(Character::toString).collect(Collectors.joining()) )
                .map( group -> group.stream().collect(Collectors.joining()) )

                .peek(System.out::println)


                .collect(Collectors.joining(" "));
                // .collect(Collectors.toList());
    }




    public static void main(String[] args) {
        String originalString1 = "HelloWorld";
        String modifiedString1 = insertSpaceEveryThree(originalString1);
        // insertSpaceEveryThree(originalString1);
        System.out.println("Original string: " + originalString1);
        System.out.println("Modified string: " + modifiedString1);

        // String originalString2 = "abcdefghijklmn";
        // String modifiedString2 = insertSpaceEveryThree(originalString2);
        // System.out.println("Original string: " + originalString2);
        // System.out.println("Modified string: " + modifiedString2);

        // String originalString3 = "abc";
        // String modifiedString3 = insertSpaceEveryThree(originalString3);
        // System.out.println("Original string: " + originalString3);
        // System.out.println("Modified string: " + modifiedString3);

        // String originalString4 = "ab";
        // String modifiedString4 = insertSpaceEveryThree(originalString4);
        // System.out.println("Original string: " + originalString4);
        // System.out.println("Modified string: " + modifiedString4);
    }

}




