import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class TestCSVExportRegression {

    @Test
    void testExportToCSV() {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addProduct(new Product(17, "Laptop Charger", 2, 750.0));

        inventoryManager.exportToCSV("inventory_report_Test.csv");

        File file = new File("inventory_report_Test.csv");
        assertTrue(file.exists(), "CSV file must be successfully generated");
    }
}
