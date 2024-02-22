package PresentationLayer.Panels.Orders;

import Model.Clients;
import Model.Products;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlaceOrder extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private final JPanel gridpanel = new JPanel();
    private final JLabel title = new JLabel("Place an order");
    private final JLabel clientL = new JLabel("Client id");
    private final JLabel productL = new JLabel("Product id");
    private final JLabel amountL = new JLabel("Amount");
    private final JComboBox clientT = new JComboBox();
    private final JComboBox productT = new JComboBox();
    private final JTextField amountT = new JTextField();
    private final JLabel tooMuch = new JLabel("Not enough products. try a smaller amount");
    private final JButton bBack = new JButton("Back");
    private final JButton bCreate = new JButton("Create");

    public PlaceOrder(){
        setBackground(new Color(0xB0B0EF));
        setLayout(springLayout);
        add(title);
        add(gridpanel);
        add(bBack);
        add(bCreate);
        add(tooMuch);

        setGrid();

        title.setFont(new Font("Arial", Font.PLAIN, 35));
        tooMuch.setFont(new Font("Arial", Font.PLAIN, 20));
        tooMuch.setForeground(Color.red);
        springLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gridpanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tooMuch, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gridpanel, 0, SpringLayout.VERTICAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.SOUTH, tooMuch, -5, SpringLayout.NORTH, gridpanel);

        bBack.setFont(new Font("Arial", Font.PLAIN, 25));
        bBack.setBackground(new Color(224, 223, 142));
        bBack.setPreferredSize(new Dimension(120, 40));
        bCreate.setFont(new Font("Arial", Font.PLAIN, 25));
        bCreate.setBackground(new Color(224, 223, 142));
        bCreate.setPreferredSize(new Dimension(120, 40));

        springLayout.putConstraint(SpringLayout.SOUTH, bBack, -20, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, bBack, -20, SpringLayout.EAST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, bCreate, -20, SpringLayout.NORTH, bBack);
        springLayout.putConstraint(SpringLayout.EAST, bCreate, -20, SpringLayout.EAST, this);
    }
    private void setGrid(){
        gridpanel.setBackground(new Color(0xB0B0EF));
        gridpanel.setLayout(new GridLayout(4, 2, 10, 20));
        gridpanel.add(clientL);
        gridpanel.add(clientT);
        gridpanel.add(productL);
        gridpanel.add(productT);
        gridpanel.add(amountL);
        gridpanel.add(amountT);

        clientL.setFont(new Font("Arial", Font.PLAIN, 20));
        productL.setFont(new Font("Arial", Font.PLAIN, 20));
        amountL.setFont(new Font("Arial", Font.PLAIN, 20));
        clientT.setFont(new Font("Arial", Font.PLAIN, 20));
        productT.setFont(new Font("Arial", Font.PLAIN, 20));
        amountT.setFont(new Font("Arial", Font.PLAIN, 20));
        clientL.setPreferredSize(new Dimension(200, 30));
    }
    public void initialize(){
        clientT.setSelectedIndex(-1);
        productT.setSelectedIndex(-1);
        amountT.setText("");
        tooMuch.setVisible(false);
    }
    public void setClients(ArrayList<Clients> list) {
        try {
            clientT.removeAllItems();
            for (Clients clients : list) {
                clientT.addItem(clients.getId());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(11);
        }
    }public void setProducts(ArrayList<Products> list) {
        try {
            productT.removeAllItems();
            for (Products products : list) {
                productT.addItem(products.getId());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(12);
        }
    }
    public JButton getbBack() {
        return bBack;
    }
    public JButton getbCreate() {
        return bCreate;
    }
    public int getClientId(){return (int) clientT.getSelectedItem();}
    public int getProductId(){return (int) productT.getSelectedItem();}
    public int getAmount(){return Integer.parseInt(amountT.getText());}
    public JLabel getWarnig(){return tooMuch;}
}
