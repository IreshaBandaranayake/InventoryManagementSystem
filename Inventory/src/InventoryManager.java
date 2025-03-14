import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class InventoryManager {
    private final List<Product> inventory = new ArrayList<>();
    private static final String FILE_NAME = "inventory.txt";

    public void loadInventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inventory.add(Product.fromString(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing inventory found. Starting fresh.");
        } catch (IOException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }
    }

    public void saveInventory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Product product : inventory) {
                writer.println(product);
            }
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public Product findProductById(int id) {
        for (Product product : inventory) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    public void removeProduct(int id) {
        inventory.removeIf(product -> product.getId() == id);
    }

    public void clearInventory() {
        inventory.clear();
    }

    public void exportToCSV(String filename) {
        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("ID,Name,Quantity,Price\n");
            for (Product product : inventory) {
                writer.write(product.getId() + "," + product.getName() + "," + product.getQuantity() + "," + product.getPrice() + "\n");
            }
            System.out.println("Inventory exported to " + filename);
        } catch (IOException e) {
            System.err.println("Error exporting to CSV: " + e.getMessage());
        }
    }

}
