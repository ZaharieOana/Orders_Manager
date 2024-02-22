package PresentationLayer.Panels.Products;

import javax.swing.*;
import java.awt.*;

public class Product extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private final JLabel title = new JLabel("Operations on products");
    private final JButton bAdd = new JButton("Add new product");
    private final JButton bEdit = new JButton("Edit product");
    private final JButton bViewAll = new JButton("View all products");
    private final JButton bBack = new JButton("Back");
    public Product(){
        setBackground(new Color(0xB0B0EF));
        setLayout(springLayout);
        add(title);
        add(bAdd);
        add(bEdit);
        add(bViewAll);
        add(bBack);

        title.setFont(new Font("Arial", Font.PLAIN, 35));
        setButtons();

        springLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bAdd, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bEdit, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bViewAll, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, bEdit, 0, SpringLayout.VERTICAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, bViewAll, 30, SpringLayout.SOUTH, bEdit);
        springLayout.putConstraint(SpringLayout.SOUTH, bAdd, -30, SpringLayout.NORTH, bEdit);
        springLayout.putConstraint(SpringLayout.SOUTH, bBack, -20, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, bBack, -20, SpringLayout.EAST, this);
    }
    private void setButtons(){
        bAdd.setFont(new Font("Arial", Font.PLAIN, 25));
        bAdd.setBackground(new Color(146, 241, 154));
        bAdd.setPreferredSize(new Dimension(250, 50));
        bEdit.setFont(new Font("Arial", Font.PLAIN, 25));
        bEdit.setBackground(new Color(146, 241, 154));
        bEdit.setPreferredSize(new Dimension(250, 50));
        bViewAll.setFont(new Font("Arial", Font.PLAIN, 25));
        bViewAll.setBackground(new Color(146, 241, 154));
        bViewAll.setPreferredSize(new Dimension(250, 50));
        bBack.setFont(new Font("Arial", Font.PLAIN, 25));
        bBack.setBackground(new Color(224, 223, 142));
        bBack.setPreferredSize(new Dimension(100, 40));
    }

    public JButton getbAdd() {
        return bAdd;
    }
    public JButton getbEdit() {
        return bEdit;
    }
    public JButton getbViewAll() {
        return bViewAll;
    }
    public JButton getbBack() {
        return bBack;
    }
}
