package poly.edu.lab5.entity;
// Bai5
public class ItemShop {
    private Integer id;
    private String name;
    private double price;
    private int qty = 1;

    public ItemShop(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public double getAmount() { return price * qty; }
}
