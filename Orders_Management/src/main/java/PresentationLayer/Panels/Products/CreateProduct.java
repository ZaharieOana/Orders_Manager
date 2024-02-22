package PresentationLayer.Panels.Products;

import javax.swing.*;
import java.awt.*;

public class CreateProduct extends JPanel{
    private final SpringLayout springLayout = new SpringLayout();
    private final JPanel gridpanel = new JPanel();
    private final JLabel title = new JLabel("Create a product");
    private final JLabel nameL = new JLabel("Name");
    private final JLabel amountL = new JLabel("Amount");
    private final JLabel priceL = new JLabel("Price");
    private final JTextField nameT = new JTextField();
    private final JTextField amountT = new JTextField();
    private final JTextField priceT = new JTextField();
    private final JButton bBack = new JButton("Back");
    private final JButton bCreate = new JButton("Create");

    public CreateProduct(){
        setBackground(new Color(0xB0B0EF));
        setLayout(springLayout);
        add(title);
        add(gridpanel);
        add(bBack);
        add(bCreate);

        setGrid();

        title.setFont(new Font("Arial", Font.PLAIN, 35));
        springLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gridpanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gridpanel, 0, SpringLayout.VERTICAL_CENTER, this);

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
        gridpanel.add(nameL);
        gridpanel.add(nameT);
        gridpanel.add(amountL);
        gridpanel.add(amountT);
        gridpanel.add(priceL);
        gridpanel.add(priceT);

        nameL.setFont(new Font("Arial", Font.PLAIN, 20));
        amountL.setFont(new Font("Arial", Font.PLAIN, 20));
        priceL.setFont(new Font("Arial", Font.PLAIN, 20));
        nameT.setFont(new Font("Arial", Font.PLAIN, 20));
        amountT.setFont(new Font("Arial", Font.PLAIN, 20));
        priceT.setFont(new Font("Arial", Font.PLAIN, 20));
        nameT.setPreferredSize(new Dimension(200, 30));
    }
    public void initialize(){
        nameT.setText("");
        amountT.setText("");
        priceT.setText("");
    }
    public JButton getbBack() {
        return bBack;
    }
    public JButton getbCreate() {
        return bCreate;
    }
    public String getNameProduct(){ return nameT.getText();};
    public int getAmount(){ return Integer.parseInt(amountT.getText());}
    public int getPrice(){ return Integer.parseInt(priceT.getText());}
}
