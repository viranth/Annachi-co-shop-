
/**
 * @author VIRANTH DHARMALINGAM
 * @Date 7 NOV 2023
 * @version JAVA 1.8
 * The CartManager class is responsible for managing the shopping cart, allowing users to add,
 * remove, view, and manipulate items in the cart. It also provides a method to generate and
 * print a bill for the items in the cart.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CartManager {
    private Map<String, Cart> cart = new HashMap<>();
    private ItemManager itemManager;

    /**
     * Constructs a CartManager with the given ItemManager, which is used to search
     * for items
     * by their ID.
     *
     * @param itemManager The ItemManager to use for item-related operations.
     */
    public CartManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    /**
     * Adds an item to the shopping cart with the specified quantity.
     *
     * @param itemId   The ID of the item to add to the cart.
     * @param quantity The quantity of the item to add.
     */
    public void addToCart(int itemId, double quantity) {
        Item item = itemManager.searchByID(itemId);
        if (item != null) {
            String itemName = item.getName();
            if (cart.containsKey(itemName)) {
                Cart cartItem = cart.get(itemName);
                double currentQty = cartItem.getTotalQty();
                cartItem.setTotalQty(currentQty + quantity);
                cartItem.setTotalPrice(cartItem.getTotalPrice() + (item.getPrice() * quantity));
            } else {
                Cart cartItem = new Cart(itemName, quantity, item.getPrice(), item.getPrice() * quantity);
                cart.put(itemName, cartItem);
            }
        }
    }

    /**
     * Removes a specified quantity of an item from the shopping cart. If the
     * resulting quantity
     * would be negative, the item is removed from the cart.
     *
     * @param itemName The name of the item to remove.
     * @param quantity The quantity of the item to remove.
     */
    public void removeFromCart(String itemName, double quantity) {
        if (cart.containsKey(itemName)) {
            Cart cartItem = cart.get(itemName);
            double currentQty = cartItem.getTotalQty();
            if (currentQty - quantity > 0) {
                cartItem.setTotalQty(currentQty - quantity);
                cartItem.setTotalPrice(cartItem.getTotalPrice() - (cartItem.getUnitPrice() * quantity));
            } else {
                // If the resulting quantity would be negative, remove the item from the cart
                cart.remove(itemName);
            }
        }
    }

    /**
     * Displays the items currently in the shopping cart along with their quantities
     * and
     * total prices.
     */
    public void viewCart() {
        System.out.println("Shopping Cart:");
        System.out.println("=========================================================");
        for (Cart item : cart.values()) {
            System.out.println(
                    item.getName() + ": Quantity = " + item.getTotalQty() + ", Total Price = $" + item.getTotalPrice());
        }
        System.out.println("=========================================================");

    }

    /**
     * Increments the quantity of a specific item in the cart by the given amount.
     *
     * @param itemName The name of the item to increment.
     * @param amount   The quantity to increment by.
     */
    public void incrementQuantity(String itemName, double amount) {
        if (cart.containsKey(itemName)) {
            Cart cartItem = cart.get(itemName);
            double currentQty = cartItem.getTotalQty();

            if (amount <= 0) {
                System.out.println("Invalid quantity. Quantity should be a positive number.");
            } else {
                cartItem.setTotalQty(currentQty + amount);
                cartItem.setTotalPrice(cartItem.getTotalPrice() + (cartItem.getUnitPrice() * amount));
            }
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    /**
     * Decrements the quantity of a specific item in the cart by the given amount.
     * If the resulting
     * quantity would be negative, the item is removed from the cart.
     *
     * @param itemName The name of the item to decrement.
     * @param amount   The quantity to decrement by.
     */
    public void decrementQuantity(String itemName, double amount) {
        if (cart.containsKey(itemName)) {
            Cart cartItem = cart.get(itemName);
            double currentQty = cartItem.getTotalQty();

            if (amount <= 0) {
                System.out.println("Invalid quantity. Quantity should be a positive number.");
            } else if (currentQty - amount >= 0) {
                cartItem.setTotalQty(currentQty - amount);
                cartItem.setTotalPrice(cartItem.getTotalPrice() - (cartItem.getUnitPrice() * amount));

                if (cartItem.getTotalQty() == 0) {
                    // Remove the item from the cart if the quantity becomes zero
                    cart.remove(itemName);
                }
            } else {
                System.out.println("Quantity cannot be negative.");
            }
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    // Add this method to your CartManager class
    /**
     * Prints a bill for the items in the cart, including item names, quantities,
     * unit prices,
     * subtotals, and the total cost.
     */
    public void printBill() {
        System.out.println("==================================================");
        System.out.println("           ANNACHI & CO");
        System.out.println("==================================================");
        System.out.println("Bill Number: " + generateBillNumber());
        System.out.println("Date: " + getCurrentDate());
        System.out.println("Time: " + getCurrentTime());
        System.out.println("Item Name           Quantity   Price   Subtotal");
        System.out.println("--------------------------------------------------");

        for (Cart cartItem : cart.values()) {
            System.out.printf("%-20s %-10.2f $%-7.2f $%-7.2f\n",
                    cartItem.getName(),
                    cartItem.getTotalQty(),
                    cartItem.getUnitPrice(),
                    cartItem.getTotalPrice());
        }

        System.out.println("---------------------------------------------------");
        double totalCost = getTotalCost();
        System.out.printf(" Total Cost: $%.2f\n", totalCost);
        System.out.println("===================================================");

        System.out.println("       THANK YOU FOR SHOPPING");
        System.out.println("===================================================");
    }

    /**
     * Generates a unique bill number for the current transaction.
     *
     * @return A unique bill number.
     */
    private String generateBillNumber() {
        // You can generate a unique bill number here, for example, using a timestamp.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return "BILL-" + sdf.format(new Date());
    }

    /**
     * Returns the current date in a specific format (dd/MM/yyyy).
     *
     * @return The current date.
     */
    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(new Date());
    }

    /**
     * Returns the current time in a specific format (HH:mm:ss).
     *
     * @return The current time.
     */
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * Calculates the total cost of all items in the shopping cart.
     *
     * @return The total cost of the items in the cart.
     */
    public double getTotalCost() {
        double totalCost = 0.0;
        for (Cart item : cart.values()) {
            totalCost += item.getTotalPrice();
        }
        return totalCost;
    }
}
