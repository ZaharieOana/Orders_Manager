package PresentationLayer;

import PresentationLayer.Panels.*;
import PresentationLayer.Panels.Clients.*;
import PresentationLayer.Panels.Orders.*;
import PresentationLayer.Panels.Products.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel();
    private final HomePage homePage= new HomePage();
    private final Client clients = new Client();
    private final Product products = new Product();
    private final Order orders = new Order();
    //panels for clients
    private final CreateClient createClient = new CreateClient();
    private final EditClient editClient = new EditClient();
    private final ViewClients viewClients = new ViewClients();
    //panels for products
    private final CreateProduct createProduct = new CreateProduct();
    private final EditProducts editProducts = new EditProducts();
    private final ViewProducts viewProducts = new ViewProducts();
    //panels for orders
    private final PlaceOrder placeOrder = new PlaceOrder();
    private final ViewOrders viewOrders = new ViewOrders();
    private final ViewBills viewBills = new ViewBills();
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 500);
        setTitle("Order Manager");
        setLocationRelativeTo(null);
        cardPanel.setLayout(cardLayout);
        cardPanel.add("homePage", homePage);
        cardPanel.add("clients", clients);
        cardPanel.add("products", products);
        cardPanel.add("orders", orders);
        cardPanel.add("createClient", createClient);
        cardPanel.add("editClient", editClient);
        cardPanel.add("viewClients", viewClients);
        cardPanel.add("createProduct", createProduct);
        cardPanel.add("editProducts", editProducts);
        cardPanel.add("viewProducts", viewProducts);
        cardPanel.add("placeOrder", placeOrder);
        cardPanel.add("viewOrders", viewOrders);
        cardPanel.add("viewBills", viewBills);
        cardLayout.show(cardPanel, "homePage");

        setButtons();

        add(cardPanel);
        setVisible(true);
    }

    /**
     * Seteaza un action listener pentru fiecare buton al interfetei al carui rezultat nu are legatura cu baza de date, ci doar cu interfata grafica
     */
    private void setButtons(){
        homePage.getbClient().addActionListener(new goToClients());
        homePage.getbProduct().addActionListener(new goToProducts());
        homePage.getbOrder().addActionListener(new goToOrders());
        clients.getbBack().addActionListener(new goToHome());
        products.getbBack().addActionListener(new goToHome());
        orders.getbBack().addActionListener(new goToHome());

        clients.getbAdd().addActionListener(e -> {
            cardLayout.show(cardPanel, "createClient");
            createClient.initialize();
        });
        createClient.getbBack().addActionListener(new goToClients());
        editClient.getbBack().addActionListener(new goToClients());
        viewClients.getbBack().addActionListener(new goToClients());

        products.getbAdd().addActionListener(e -> cardLayout.show(cardPanel, "createProduct"));
        createProduct.getbBack().addActionListener(new goToProducts());
        editProducts.getbBack().addActionListener(new goToProducts());
        viewProducts.getbBack().addActionListener(new goToProducts());

        placeOrder.getbBack().addActionListener(new goToOrders());
        viewOrders.getbBack().addActionListener(new goToOrders());
        viewBills.getbBack().addActionListener(new goToOrders());
    }
    public void goToEditClient(){ cardLayout.show(cardPanel, "editClient");}
    public void goToViewClients(){ cardLayout.show(cardPanel, "viewClients");}
    public void goToEditProducts(){ cardLayout.show(cardPanel, "editProducts");}
    public void goToViewProducts(){ cardLayout.show(cardPanel, "viewProducts");}
    public void goToPlaceOrder(){ cardLayout.show(cardPanel, "placeOrder");}
    public void goToViewOrders(){ cardLayout.show(cardPanel, "viewOrders");}
    public void goToViewBills(){ cardLayout.show(cardPanel, "viewBills");}
    private class goToClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, "clients");
        }
    }
    private class goToProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, "products");
        }
    }
    private class goToOrders implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, "orders");
        }
    }
    private class goToHome implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, "homePage");
        }
    }
    public CreateClient getCreateClient() {
        return createClient;
    }
    public EditClient getEditClient() {
        return editClient;
    }
    public ViewClients getViewClients() {
        return viewClients;
    }
    public CreateProduct getCreateProduct() {
        return createProduct;
    }
    public EditProducts getEditProducts() {
        return editProducts;
    }
    public ViewProducts getViewProducts() {
        return viewProducts;
    }
    public PlaceOrder getPlaceOrder() {
        return placeOrder;
    }
    public ViewOrders getViewOrders() {
        return viewOrders;
    }
    public ViewBills getViewBills() {
        return viewBills;
    }
    public Client getClients() {
        return clients;
    }
    public Product getProducts() {
        return products;
    }
    public Order getOrders() {
        return orders;
    }
}
