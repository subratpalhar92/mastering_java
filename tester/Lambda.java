import java .util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
        // IntSupplier is = () -> { return 5; };
        // System.out.println(is.getAsInt());

        // DoubleSupplier ds = () -> {return 3.141; };
        // System.out.println(ds.getAsDouble());

        // Supplier<Integer> iss = () -> {return 6;};
        // System.out.println(iss.get()); // @TODO

        /** Consumer */
        // IntConsumer i = (ii) -> {System.out.println(ii);};
        // i.accept(8);
        // i.accept(new Integer(9));

        // Consumer<Character> c = (arg) -> {System.out.println(arg);};
        // c.accept('H');

        // BiConsumer<Integer, String> bc = (arg1, arg2) -> System.out.println(arg1 + arg2);
        // bc.accept(9, " - Times Hello");



        /** Predicate */
        // IntPredicate p = arg -> arg == 100;
        // System.out.println(p.test(50));

        // Predicate<String> ps = arg -> arg.equalsIgnoreCase("Hello");
        // System.out.println(ps.test("hello"));

        /** Function */
        IntFunction iff = i -> { if (i==5) { return "Five"; } else { return "Fuck Yourself"; }  };
        System.out.println(iff.apply(5));

    }
}
