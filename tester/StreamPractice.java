import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        Optional<Integer> oint = ll.stream().max(Integer::compareTo);
        System.out.println(oint.get());

        OptionalInt oi = IntStream.of(1,2,4,6).max();
        System.out.println(oi.getAsInt());

        System.

        System.out.println(ll.stream().collect(Collectors.groupingBy(i -> i % 2)));
        System.out.println(ll.stream().collect(Collectors.groupingBy(i -> i % 2 == 0 ? "Even" : "Odd", Collectors.counting())));






        

        List<Integer> ll = IntStream.of(1,2,3,4,5).filter( i -> i%2 == 0).boxed().collect(Collectors.toList());
        System.out.println(ll);
      
        int sumDigits = IntStream.of(1,2,3,4,5).sum();
    }
}
