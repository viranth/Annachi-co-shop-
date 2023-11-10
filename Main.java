
/**
 * @author VIRANTH DHARMALINGAM
 * @date 7 NOV 2023
 * @version JAVA 1.8
 * The Main class represents the main program for managing a grocery store with stock items
 * and a shopping cart. It provides a menu-driven interface for managing stock items and
 * shopping cart operations.
 */

import java.util.Scanner;

public class Main {
    ItemManager itemManager = new ItemManager();
    CartManager cartManager = new CartManager(itemManager);
    Scanner sc = new Scanner(System.in);

    /**
     * Constructs an instance of the Main class, initializes stock items, and starts
     * the
     * interactive program for managing the grocery store.
     */
    public Main() {
        StockWithGroceryItems();
        annachiKadai();

    }

    /**
     * Initializes the stock with some sample grocery items.
     */
    public void StockWithGroceryItems() {
        Item item1 = new Item("Apple", 10, 5.0);
        Item item2 = new Item("Banana", 8, 8.0);
        Item item3 = new Item("Milk", 3, 2.0);
        Item item4 = new Item("Bread", 2, 1.0);
        Item item5 = new Item("Eggs", 5, 12.0);

        itemManager.addStock(item1);
        itemManager.addStock(item2);
        itemManager.addStock(item3);
        itemManager.addStock(item4);
        itemManager.addStock(item5);
    }

    /**
     * Manages the stock items by providing options for adding, updating, and
     * viewing stock items.
     */
    public void manageStockItems() {

        boolean stockLoopChoice = true;
        // Stock item management submenu
        while (stockLoopChoice) {
            System.out.println();
            System.out.println("============================");
            System.out.println("Stock Item Management:");
            System.out.println("1. Add Stock Item");
            System.out.println("2. Update Stock Item");
            System.out.println("3. View Stock Items");
            System.out.println("4. Search Stock Items(Stock Name)");
            System.out.println("5. Search Stock Items(Stock ID)");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            System.out.println("============================");
            System.out.println();

            int stockChoice = sc.nextInt();

            switch (stockChoice) {
                case 1:
                    // Add a stock item
                    addStockItem();
                    break;
                case 2:
                    // Update a stock item
                    updateStockItem();
                    break;
                case 3:
                    // View stock items
                    itemManager.viewInventory();
                    break;
                case 4:
                    System.out.println("Enter the stock name to search : ");
                    String searchName = sc.next();
                    Item itemSearchByName = itemManager.searchByName(searchName);
                    System.out.println("-------The searched product-------");
                    System.out.println(itemSearchByName);
                    System.out.println("---------------------------------- ");
                    break;
                case 5:
                    System.out.println("Enter the stock name to search : ");
                    int SearchId = sc.nextInt();
                    Item itemsearchById = itemManager.searchByID(SearchId);// Return to the main menu
                    System.out.println("-------The searched product-------");
                    System.out.println(itemsearchById);
                    System.out.println("---------------------------------- ");

                    break;
                case 6:
                    stockLoopChoice = false;// Return to the main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    /**
     * Adds a new stock item to the inventory by taking user input for name, price,
     * and quantity.
     */
    public void addStockItem() {
        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter item price: ");
        int price = sc.nextInt();
        System.out.print("Enter item quantity: ");
        double quantity = sc.nextDouble();

        Item newItem = new Item(name, price, quantity);
        itemManager.addStock(newItem);
        System.out.println("Item added to stock.");
    }

    /**
     * Updates an existing stock item's price and quantity by taking user input.
     */
    public void updateStockItem() {
        System.out.print("Enter item ID to update: ");
        int itemIdToUpdate = sc.nextInt();
        Item existingItem = itemManager.searchByID(itemIdToUpdate);

        if (existingItem != null) {
            System.out.print("Enter new price: ");
            int newPrice = sc.nextInt();
            System.out.print("Enter new quantity: ");
            double newQuantity = sc.nextDouble();

            existingItem.setPrice(newPrice);
            existingItem.setQuantity(newQuantity);
            System.out.println("Item updated.");
        } else {
            System.out.println("Item not found. Please enter a valid item ID.");
        }
    }

    /**
     * Manages the shopping cart by providing options for adding, incrementing,
     * decrementing, viewing,
     * calculating total cost, and printing the bill for items in the cart.
     */
    public void manageShoppingCart() {
        // Shopping cart management submenu
        boolean cartToChoice = true;
        while (cartToChoice) {
            System.out.println();
            System.out.println("---------------------------");
            System.out.println("Shopping Cart Management:");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. Increment Item Quantity");
            System.out.println("3. Decrement Item Quantity");
            System.out.println("4. View Cart");
            System.out.println("5. Calculate Total Cost");
            System.out.println("6. Print the Bill");
            System.out.println("7. Back to Main Menu");
            System.out.println("---------------------------");
            System.out.println();
            System.out.print("Enter your choice: ");

            int cartChoice = sc.nextInt();

            switch (cartChoice) {
                case 1:
                    // Add an item to the cart
                    addItemToCart();
                    break;
                case 2:
                    // Increment item quantity
                    incrementItemQuantity();
                    break;
                case 3:
                    // Decrement item quantity
                    decrementItemQuantity();
                    break;
                case 4:
                    cartManager.viewCart();
                    break;
                case 5:
                    double totalCost = cartManager.getTotalCost();
                    System.out.println("Total Cost: $" + totalCost);
                    break;
                case 6:
                    cartManager.printBill();
                    break;
                case 7:
                    cartToChoice = false;
                    break; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    /**
     * Adds an item to the shopping cart by taking user input for the item's ID and
     * quantity.
     */
    public void addItemToCart() {
        System.out.print("Enter item ID to add to the cart: ");
        int itemIdToAdd = sc.nextInt();

        Item itemToAdd = itemManager.searchByID(itemIdToAdd);

        if (itemToAdd == null) {
            System.out.println("Invalid item ID. The item does not exist.");
        } else {
            System.out.print("Enter quantity to add: ");
            double quantityToAdd = sc.nextDouble();

            if (quantityToAdd <= 0) {
                System.out.println("Invalid quantity. Quantity should be a positive number.");
            } else if (quantityToAdd < itemToAdd.getQuantity()) {
                System.out.print(
                        "The quantity is less than you want. Do you want to proceed (yes/no)? ");
                String confirmation = sc.next().toLowerCase();

                if (confirmation.equals("yes")) {
                    cartManager.addToCart(itemIdToAdd, quantityToAdd);
                    System.out.println("Item added to the cart.");
                } else if (confirmation.equals("no")) {
                    System.out.println("Order canceled.");
                } else {
                    System.out.println(
                            "Invalid confirmation choice. Please enter 'yes' or 'no'.");
                }
            } else {
                cartManager.addToCart(itemIdToAdd, quantityToAdd);
                System.out.println("Item added to the cart.");
            }
        }
    }

    /**
     * Increments the quantity of an item in the shopping cart by taking user input
     * for item name and
     * quantity to increment.
     */
    public void incrementItemQuantity() {
        System.out.print("Enter item name to increment quantity: ");
        String itemNameToIncrement = sc.nextLine();
        System.out.print("Enter quantity to increment: ");
        double quantityToIncrement = sc.nextDouble();

        cartManager.incrementQuantity(itemNameToIncrement, quantityToIncrement);
        System.out.println("Quantity incremented.");
    }

    /**
     * Exits the program by closing the scanner and terminating the application.
     */
    public void exitProgram() {
        System.out.println("Exiting the program.");
        sc.close();
        System.exit(0);
    }

    /**
     * Decrements the quantity of an item in the shopping cart by taking user input
     * for item name and
     * quantity to decrement.
     */
    public void decrementItemQuantity() {
        System.out.print("Enter item name to decrement quantity: ");
        String itemNameToDecrement = sc.nextLine();
        System.out.print("Enter quantity to decrement: ");
        double quantityToDecrement = sc.nextDouble();

        cartManager.decrementQuantity(itemNameToDecrement, quantityToDecrement);
        System.out.println("Quantity decremented.");
    }

    /**
     * The `annachiKadai` method serves as the main menu of the program, providing
     * options for managing
     * stock items, managing the shopping cart, or exiting the program. It runs in
     * an infinite loop
     * until the user chooses to exit.
     */
    public void annachiKadai() {

        while (true) {
            System.out.println();
            System.out.println("============================");
            System.out.println("Main Menu:");
            System.out.println("1. Manage Stock Items");
            System.out.println("2. Manage Shopping Cart");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("============================");
            System.out.println();

            int mainChoice = sc.nextInt();
            // Consume newline

            switch (mainChoice) {
                case 1:
                    manageStockItems();
                    break;
                case 2:
                    manageShoppingCart();
                    break;
                case 3:
                    exitProgram();
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    /**
     * The main method is the entry point for the program and creates an instance of
     * the Main class to
     * start the grocery store management program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Main main = new Main();
    }
}
