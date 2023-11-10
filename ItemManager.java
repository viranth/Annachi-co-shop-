
/**
 * @author VIRANTH DHARMALINGAM
 * @date 7 NOV 2023
 * @version JAVA 1.8
 * The ItemManager class is responsible for managing the stock of items available in the store.
 * It allows you to add, update, search for, and view items in the inventory.
 */
import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    private int nextItemId = 1;
    private Map<Integer, Item> stock = new HashMap<>();

    /**
     * Generates a unique ID for an item. Each item added to the stock will be
     * assigned a unique ID.
     *
     * @return A unique item ID.
     */
    public int generateId() {
        return nextItemId++;
    }

    /**
     * Adds an item to the stock. If an item with the same name already exists in
     * the stock,
     * it updates the quantity of that item; otherwise, it generates a new ID for
     * the item and
     * adds it to the stock.
     *
     * @param item The item to add or update in the stock.
     */
    public void addStock(Item item) {
        // Search for an item with the same name
        Item existingItem = searchByName(item.getName());

        if (existingItem != null) {
            // Item with the same name found, update the quantity
            double currentQuantity = existingItem.getQuantity();
            double newQuantity = currentQuantity + item.getQuantity();
            existingItem.setQuantity(newQuantity);
        } else {
            // If no matching item is found, generate a new ID and add the item to the stock
            int itemId = generateId();
            item.setId(itemId);
            stock.put(itemId, item);
        }
    }

    /**
     * Searches for an item in the stock by its name.
     *
     * @param name The name of the item to search for.
     * @return The found item or null if the item is not in the stock.
     */
    public Item searchByName(String name) {
        for (Item item : stock.values()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null; // Item not found
    }

    /**
     * Searches for an item in the stock by its ID.
     *
     * @param itemId The ID of the item to search for.
     * @return The found item or null if the item is not in the stock.
     */
    public Item searchByID(int itemId) {
        return stock.get(itemId);
    }

    /**
     * Displays the inventory of all items in the stock.
     */
    public void viewInventory() {
        System.out.println();
        System.out.println("=================================================");
        for (Item item : stock.values()) {
            System.out.println(item.toString());
        }
        System.out.println("=================================================");

    }

    /**
     * Updates the price of an item in the stock.
     *
     * @param itemId   The ID of the item to update.
     * @param newPrice The new price of the item.
     */
    public void updatePrice(int itemId, int newPrice) {
        Item item = stock.get(itemId);
        if (item != null) {
            item.setPrice(newPrice);
        }
    }

    /**
     * Updates the quantity of an item in the stock.
     *
     * @param itemId      The ID of the item to update.
     * @param newQuantity The new quantity of the item.
     */
    public void updateQty(int itemId, double newQuantity) {
        Item item = stock.get(itemId);
        if (item != null) {
            item.setQuantity(newQuantity);
        }
    }

    /**
     * Increments the quantity of an item in the stock.
     *
     * @param itemId The ID of the item to increment.
     * @param amount The quantity to increment by.
     */
    public void increment(int itemId, double amount) {
        Item item = stock.get(itemId);
        if (item != null) {
            double currentQuantity = item.getQuantity();
            item.setQuantity(currentQuantity + amount);
        }
    }

    /**
     * Decrements the quantity of an item in the stock. If the resulting quantity
     * would be negative,
     * it prevents the decrement and displays an error message.
     *
     * @param itemId The ID of the item to decrement.
     * @param amount The quantity to decrement by.
     */
    public void decrement(int itemId, double amount) {
        Item item = stock.get(itemId);
        if (item != null) {
            double currentQuantity = item.getQuantity();
            if (currentQuantity - amount >= 0) {
                item.setQuantity(currentQuantity - amount);
            } else {
                System.out.println("Quantity cannot be negative.");
            }
        }
    }
}
