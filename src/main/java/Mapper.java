import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class Mapper {
    public static <T, R> Collection<R> map(Function<T, R> mapper, Iterable<T> values) {
        Collection<R> accumulator = new ArrayList<>();
        for (T value : values) {
            accumulator.add(mapper.apply(value));
        }
        return accumulator;
    }
}
