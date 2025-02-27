import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class TestAddNewProduct {

    @Test
    void testAddProduct() {
        InventoryManager inventoryManager = new InventoryManager();
        Product item = new Product(12, "Digital Camera", 4, 12500.0);

        inventoryManager.addProduct(item);
        List<Product> inventoryList = inventoryManager.getInventory();

        assertTrue(inventoryList.contains(item), "Newly added inventory item must be added to the inventory list");
    }
}
