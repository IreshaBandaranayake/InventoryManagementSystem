import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDeleteProduct {

    @Test
    void testDeleteInventoryProduct() {
        InventoryManager inventoryManager = new InventoryManager();
        Product item = new Product(13, "Computer Table", 2, 2000.0);
        inventoryManager.addProduct(item);

        inventoryManager.removeProduct(13);

        assertNull(inventoryManager.findProductById(13), "Inventory Product must be deleted from inventory list");
    }
}
