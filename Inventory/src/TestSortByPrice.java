import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TestSortByPrice {
    @Test
    void testSortProductsByPrice() {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addProduct(new Product(25, "Table", 2, 2500.0));
        inventoryManager.addProduct(new Product(26, "Chair", 8, 700.0));
        inventoryManager.addProduct(new Product(27, "Cupboard", 7, 1250.0));

        assertFalse(inventoryManager.getInventory().isEmpty(), "Before the sort Inventory must not be empty.");

        String simulatedInput = "1\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        SortProductsByPrice sortProducts = new SortProductsByPrice(inventoryManager);
        sortProducts.execute();

        System.setIn(originalSystemIn);

        List<Product> sortedProducts = new ArrayList<>(inventoryManager.getInventory());
        sortedProducts.sort(Comparator.comparingDouble(Product::getPrice));

        assertEquals(sortedProducts.get(0).getId(), 26, "1st product must be the lowest price-chair.");
        assertEquals(sortedProducts.get(1).getId(), 27, "2nd product must be Cupboard.");
        assertEquals(sortedProducts.get(2).getId(), 25, "3rd product must be the highest price- Table.");
    }
}


