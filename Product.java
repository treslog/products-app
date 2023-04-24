public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;

    }

    public String toString() {
        return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units, Total: $ "
                + String.format("%.2f");
    }
}
