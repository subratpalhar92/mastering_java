import java.util.*;

public class MyTreeSet {

    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(2);
        ts.add(3);
        ts.add(4);
        ts.add(5);

        int sum1 = 0;
        for (Integer i : ts) {
            sum1 += i;
        }

        System.out.println(sum1);


        int sum2 = ts.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum2);
    }

}
