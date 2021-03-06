class ItemReference {
    private final String itemCode;
    private final Price unitPrice;
    public static Builder itemReferenceBuilder = new Builder();

    private ItemReference(String itemCode, Price unitPrice) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
    }

    boolean matchSoughtItemCode(String soughtItemCode) {
        return itemCode.equals(soughtItemCode);
    }

    Price getUnitPrice() {
        return unitPrice;
    }

    static final class Builder {
        private String itemCode;
        private Price unitPrice;

        private Builder() {
        }

        Builder withItemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        Builder withUnitPrice(double unitPrice) {
            return withUnitPrice(Price.valueOf(unitPrice));
        }

        Builder withUnitPrice(Price unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        ItemReference build() {
            return new ItemReference(itemCode, unitPrice);
        }
    }
}
