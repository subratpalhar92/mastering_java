import java.util.Arrays;

public class MyTestACL {


    public static void main(String[] args) {
        int[] numbers = {4, 3, 6, 1, 3, 7, 8, 9}; // remove duplicate if any
        Arrays.sort(numbers); // 7 10

        for (int i = 0; i < numbers.length; i++) {

            // for idx bound of exception
            if ((i + 1) == numbers.length) { break; }

            // for duplicate
            if (numbers[i] == numbers[i+1] ) { continue; }

            // find missing
            if (((numbers[i + 1] - numbers[i]) > 1) ) {
                // there could be misg more than 1
                int start = numbers[i];
                while ( start < (numbers[i+1] -1)  ) {
                    System.out.println("missing - " + (++start) );
                }
            }
        }
    }


}

