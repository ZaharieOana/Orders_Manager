package Model;

public class Products {
    private int id;
    private String name;
    private int amount;
    private int price;

    public Products(){}
    public Products(int id, String name, int amount, int price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
    public Products(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public int getPrice() {
        return price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
