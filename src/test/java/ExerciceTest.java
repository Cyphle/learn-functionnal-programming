import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciceTest {
    CashRegister cashRegister = new CashRegister();
    PriceQuery priceQuery = new InmemoryCatalog(
            ItemReference.itemReferenceBuilder.withItemCode("APPLE").withUnitPrice(1.20).build(),
            ItemReference.itemReferenceBuilder.withItemCode("BANANA").withUnitPrice(1.90).build()
    );


    @Test
    public void total_is_product_of_quantity_by_item_price_corresponding_to_existing_item_code() {
        Result total = cashRegister.total(priceQuery.findPrice("APPLE"), Quantity.valueOf(1));
        assertThat(total).isEqualTo(Result.found(Price.valueOf(1 * 1.20)));
    }

    @Test
    public void total_is_product_of_quantity_by_item_price_corresponding_to_existing_item_code_2() {
        Result total = cashRegister.total(priceQuery.findPrice("APPLE"), Quantity.valueOf(2));
        assertThat(total).isEqualTo(Result.found(Price.valueOf(2 * 1.20)));
    }

    @Test
    public void total_is_product_of_quantity_by_item_price_corresponding_to_existing_item_code_3() {
        Result total = cashRegister.total(priceQuery.findPrice("BANANA"), Quantity.valueOf(10));
        assertThat(total).isEqualTo(Result.found(Price.valueOf(10 * 1.90)));
    }
    @Test
    public void total_not_found_when_item_price_not_found() {
        Result total = cashRegister.total(priceQuery.findPrice("PEACH"), Quantity.valueOf(1));
        assertThat(total).isEqualTo(Result.notFound("PEACH"));
    }
}
