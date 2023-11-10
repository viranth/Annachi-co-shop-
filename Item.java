/**
 * @author VIRANTH DHARMALINGAM
 * @date 7 NOV 2023
 * @version JAVA 1.8
 * The `Item` class represents a product in the inventory of a store. It contains information about
 * the item's name, price, and quantity. This class is used to manage and manipulate items in the inventory.
 */
public class Item {

    private int id;
    private String name;
    private int price;
    private double quantity;

    /**
     * Constructs an `Item` object with the specified attributes.
     *
     * @param name     The name of the item.
     * @param price    The price of the item.
     * @param quantity The quantity of the item in stock.
     */
    public Item(String name, int price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return id + " : " + name + " : " + price + " : " + quantity;
    }

}
