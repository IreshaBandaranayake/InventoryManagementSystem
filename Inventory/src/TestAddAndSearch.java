import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class TestAddAndSearch {

    @Test
    void testProductAddAndSearch() {
        InventoryManager inventoryManager = new InventoryManager();
        SearchProduct searchProduct = new SearchProduct(inventoryManager);


        Product item = new Product(15, "Printer", 5, 5000.0);
        inventoryManager.addProduct(item);

        String simulatedInput = "15\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        searchProduct.execute();

        System.setIn(originalSystemIn);

        assertNotNull(inventoryManager.findProductById(15), "Inventory Product must be found after adding it");
        assertEquals("Printer", inventoryManager.findProductById(15).getName(), "Product Item name must be same");
    }
}
