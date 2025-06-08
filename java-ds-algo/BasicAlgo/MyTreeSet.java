import java.util.*;

public class MyTreeSet {

    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(2);
        ts.add(3);
        ts.add(4);
        ts.add(5);

        int sum = 0;
        for (Integer i : ts) {
            sum += i;
        }

        System.out.println(sum);
    }

}
