import java.util.Objects;
import java.util.function.UnaryOperator;

abstract class Result {
    abstract Result map(UnaryOperator<Price> f);

    static Result found(Price price) {
        return new Found(price);
    }

    static Result notFound(String invalidItemCode) {
        return new NotFound(invalidItemCode);
    }

    @Override
    public String toString() {
        return "Result{}";
    }

    private static class Found extends Result {
        private final Price price;

        private Found(Price price) { this.price = price; }

        @Override
        Result map(UnaryOperator<Price> f) {
            return found(f.apply(price));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Found found = (Found) o;
            return Objects.equals(price, found.price);
        }

        @Override
        public int hashCode() {
            return Objects.hash(price);
        }

        @Override
        public String toString() {
            return "Found{" +
                    "price=" + price +
                    '}';
        }
    }

    private static class NotFound extends Result {
        private final String invalidItemCode;

        private NotFound(String invalidItemCode) { this.invalidItemCode = invalidItemCode; }

        @Override
        Result map(UnaryOperator<Price> f) {
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NotFound notFound = (NotFound) o;
            return Objects.equals(invalidItemCode, notFound.invalidItemCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(invalidItemCode);
        }

        @Override
        public String toString() {
            return "NotFound{" +
                    "invalidItemCode='" + invalidItemCode + '\'' +
                    '}';
        }
    }
}
