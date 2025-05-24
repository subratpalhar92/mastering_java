import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Stream;
import java.util.function.Function;

public class StreamOperation {

    public static void main(String[] args) {

        int [] arr = {1,2,3};
        List<Integer> lst = new ArrayList<>();
            lst.add(1);
            lst.add(2);
            lst.add(3);

        /** Primitive Stream */
        // IntStream.of(1,2,3).sum();
        // LongStream.of(1,2,3).sum();
        // DoubleStream.of(1,2,3).sum();


        /** Stream */
        // Stream.of(1, 2, 3).mapToInt(Integer::intValue).sum();
        // Stream.of(arr).flatMapToInt(Arrays::stream).sum();   /** Array Of Array Stream */


        /** Array */
        // System.out.println(Arrays.stream(arr).sum()); 


        /** List */
        // lst.stream().mapToInt(Integer::intValue).sum();

        // Arrays.asList(1, 2, 3).stream().mapToInt(Integer::intValue).sum();
        // Arrays.asList(arr).stream().flatMapToInt(Arrays::stream).sum();


        // /** Optional */
        // Optional<Boolean> boo1 = Optional.of(true); // of(null) is compile time error
        // Optional<Boolean> boo2 = Optional.ofNullable(null);
        // Optional<Boolean> boo3 = Optional.empty();

        // /**
        //  * isPresent - Just general purpose returns T/F
        //  * ifpresent - Takes a consumer
        //  */
        // if (boo1.isPresent()) { System.out.println(boo1.get()); } // T
        // if (boo2.isPresent()) { System.out.println(boo2.get()); }
        // if (boo3.isPresent()) { System.out.println(boo3.get()); }

        // boo1.ifPresent(System.out::println); // T
        // boo2.ifPresent(System.out::println);
        // boo3.ifPresent(System.out::println);

        // System.out.println("---------");
        // System.out.println(boo1.orElse(false)); // T
        // System.out.println(boo2.orElse(false)); // F
        // System.out.println(boo3.orElse(false)); // F


        // /**
        //  * More on Stream max() & min() & optional
        //  */
        // Optional<Integer> i = Stream.of(1,2,3).filter(k -> k>10).max(Integer::compareTo);
        // System.out.println(i.orElse(8));

        // OptionalInt maxNumber = IntStream.of(1,2,3).filter(k -> k>10).max();
        // System.out.println(maxNumber.orElse(9));



        /** Searching */
        // boolean b1 = IntStream.of(1,2,3).filter(k -> k<10).allMatch(k -> k<5);
        // System.out.println(b1);

        // boolean b2 = IntStream.of(1,2,3).filter(k -> k<10).anyMatch(k -> k<5);
        // System.out.println(b2);

        // boolean b3 = IntStream.of(1,2,3).filter(k -> k<10).noneMatch(k -> k<5);
        // System.out.println(b3);


        // OptionalInt b4 = IntStream.of(1,2,3).filter(k -> k<10).findFirst();
        // System.out.println(b4.getAsInt());

        // OptionalInt b5 = IntStream.of(1,2,3).filter(k -> k<10).findAny();
        // System.out.println(b5.getAsInt());


        /** Sorting */
        // IntStream.of(1,2,3).sorted().forEach(System.out::print);

        /** Collecting Values */
        // List<Integer> llC = IntStream.of(1,2,3).boxed().collect(Collectors.toList());
        // System.out.println(llC);

        // Map<String, List<Integer>> llG1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        //     .boxed()
        //     .collect(Collectors.groupingBy(i -> i%2 == 0 ? "Even":"Odd"));
        // System.out.println(llG1);


        // Map<String, Integer> llG2 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        //     .boxed()
        //     .collect(Collectors.groupingBy(
        //         i -> i % 2 == 0 ? "Even" : "Odd",
        //         Collectors.summingInt(Integer::intValue)
        //     ));
        // System.out.println(llG2);


        // Map<String, Long> llG3 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).boxed().collect(Collectors.groupingBy(i -> i % 2 == 0 ? "Even" : "Odd", Collectors.counting()));
        // System.out.println(llG3);


        // List<Integer> nameLengths = Arrays.asList("Alice", "Bob", "David").stream().collect(Collectors.mapping(String::length, Collectors.toList()));
        // System.out.println(nameLengths);

        // String joinedString = IntStream.of(1,2,3).boxed().map(String::valueOf).collect(Collectors.joining(", "));
        // System.out.println(joinedString);


        // Optional<Integer> maxInteger = IntStream.of(5, 2, 8, 1, 9, 4).boxed().collect(Collectors.maxBy(Comparator.naturalOrder()));
        // maxInteger.ifPresent(System.out::println);





        /** FlatMAP */
        /**
         * Stream.of(1, 2, 3) similiar to array of stream
         * But if we pass an ARRAY to Stream.of()
         */
        Stream<int []> sarrarr1 = Stream.of(arr);
        System.out.println(sarrarr1); // java.util.stream.ReferencePipeline$Head@6d06d69c // Head
        IntStream sarrarr2 = sarrarr1.flatMapToInt(Arrays::stream);
        System.out.println(sarrarr2); // java.util.stream.ReferencePipeline$8@6ce253f1
        sarrarr2.forEach(System.out::print);
        System.out.println();



        /** 
         * --------------------------------------------------------------------------------------------------------
         * Generating Stream
         * --------------------------------------------------------------------------------------------------------
         */
        Stream.iterate(0, s->s+1).limit(4).forEach(System.out::print);
        System.out.println();

        String alphabets = IntStream.rangeClosed('A', 'Z') // int
        .mapToObj((int i) -> { return (char) i; }) // charObj
        .map(String::valueOf) // str
        .collect(Collectors.joining(""));
        System.out.println(alphabets);


        /** 
         * --------------------------------------------------------------------------------------------------------
         * Parallel Stream
         * --------------------------------------------------------------------------------------------------------
         */
        int parallelSum = IntStream.of(1,2,3,4,5).parallel().sum();
        System.out.println(parallelSum);

    }

}
