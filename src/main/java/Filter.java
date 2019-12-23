import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Filter {
    public static <T> Collection<T> filter(Predicate<T> predicate, Iterable<T> values) {
        Collection<T> accumulator = new ArrayList<>();
        for (T value : values) {
            if (predicate.test(value)) {
                accumulator.add(value);
            }
        }
        return accumulator;
    }
}
