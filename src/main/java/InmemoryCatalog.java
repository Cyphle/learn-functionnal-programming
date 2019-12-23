import java.util.Arrays;

class InmemoryCatalog implements PriceQuery {
    private final ItemReference[] itemReferences;

    public InmemoryCatalog(ItemReference... itemReferences) {
        this.itemReferences = itemReferences;
    }

    public Result findPrice(String soughtItemCode) {
        return Reducer.reduce(
                Result.notFound(soughtItemCode),
                (result, itemReference) -> Result.found(itemReference.getUnitPrice()),
                Filter.filter(itemReference -> itemReference.matchSoughtItemCode(soughtItemCode), Arrays.asList(itemReferences))
        );
    }
}
