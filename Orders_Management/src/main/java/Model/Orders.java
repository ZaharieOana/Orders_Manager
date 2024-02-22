package Model;

public class Orders {
    private int id;
    private int client_id;
    private int product_id;
    private int amount;
    private int sum;

    public Orders(){}
    public Orders(int id, int client_id, int product_id, int amount, int sum) {
        this.id = id;
        this.client_id = client_id;
        this.product_id = product_id;
        this.amount = amount;
        this.sum = sum;
    }
    public Orders(int client_id, int product_id, int amount, int sum) {
        this.client_id = client_id;
        this.product_id = product_id;
        this.amount = amount;
        this.sum = sum;
    }
    public int getId() {
        return id;
    }
    public int getClient_id() {
        return client_id;
    }
    public int getProduct_id() {
        return product_id;
    }
    public int getAmount() {
        return amount;
    }
    public int getSum() {
        return sum;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}
