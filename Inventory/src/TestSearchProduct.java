import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestSearchProduct {

    @Test
    void testSearchProductById() {
        InventoryManager inventoryManager = new InventoryManager();
        Product item = new Product(12, "Calculator", 8, 8750.0);
        inventoryManager.addProduct(item);

        Product search = inventoryManager.findProductById(12);
        assertNotNull(search, "Inventory Product must be Searched by the ID");
        assertEquals(12, search.getId(), "Searched inventory product ID must be same");
    }
}
