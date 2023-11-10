/**
 * @author VIRANTH DHARMALINGAM
 * @date 7 NOV 2023
 * @version JAVA 1.8
 * The `Cart` class represents an item in the shopping cart. It contains information about the
 * item's name, total quantity, unit price, and total price. This class is used to manage and
 * manipulate items in the shopping cart.
 */
public class Cart {

    private int id;
    private String name;
    private double totalQty;
    private double unitPrice;
    private double totalPrice;

     /**
     * Constructs a Cart object with the specified attributes.
     *
     * @param name        The name of the item in the cart.
     * @param totalQty    The total quantity of the item in the cart.
     * @param unitPrice   The unit price of the item.
     * @param totalPrice   The total price of the item (quantity multiplied by unit price).
     */
    public Cart(String name, double totalQty, double unitPrice, double totalPrice) {
        this.name = name;
        this.totalQty = totalQty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
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

    public double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(double totalQty) {
        this.totalQty = totalQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return id + " : " + name + " : " + totalQty + " : " + unitPrice
                + " : " + totalPrice;
    }

}
