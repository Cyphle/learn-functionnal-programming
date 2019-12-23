class Quantity {
    private final double value;

    static Quantity valueOf(double value) {
        return new Quantity(value);
    }

    private Quantity(double value) { this.value = value; }

    double multiplyBy(double value) { return this.value * value; }
}
