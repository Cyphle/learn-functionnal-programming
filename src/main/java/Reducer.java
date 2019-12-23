import java.util.function.BiFunction;

public class Reducer {
    public static <R, T> R reduce(R identity,
                    BiFunction<R, T, R> reducer,
                    Iterable<T> values
    ) {
        R accumulator = identity;
        for (T value : values) {
            accumulator = reducer.apply(accumulator, value);
        }
        return accumulator;
    }
}
