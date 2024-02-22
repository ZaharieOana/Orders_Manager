package PresentationLayer.Panels.Products;

import Model.Products;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditProducts extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private final JPanel gridpanel = new JPanel();
    private final JLabel title = new JLabel("Edit a product");
    private final JLabel idL = new JLabel("ID");
    private final JLabel nameL = new JLabel("Name");
    private final JLabel amountL = new JLabel("Amount");
    private final JLabel priceL = new JLabel("Price");
    private final JComboBox idT = new JComboBox();
    private final JTextField nameT = new JTextField();
    private final JTextField amountT = new JTextField();
    private final JTextField priceT = new JTextField();
    private final JButton bBack = new JButton("Back");
    private final JButton bEdit = new JButton("Edit");
    private final JButton bDelete = new JButton("Delete");

    public EditProducts(){
        setBackground(new Color(0xB0B0EF));
        setLayout(springLayout);
        add(title);
        add(gridpanel);
        add(bBack);
        add(bEdit);
        add(bDelete);

        setGrid();

        title.setFont(new Font("Arial", Font.PLAIN, 35));
        springLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gridpanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gridpanel, 0, SpringLayout.VERTICAL_CENTER, this);

        bBack.setFont(new Font("Arial", Font.PLAIN, 25));
        bBack.setBackground(new Color(224, 223, 142));
        bBack.setPreferredSize(new Dimension(120, 40));
        bEdit.setFont(new Font("Arial", Font.PLAIN, 25));
        bEdit.setBackground(new Color(224, 223, 142));
        bEdit.setPreferredSize(new Dimension(120, 40));
        bDelete.setFont(new Font("Arial", Font.PLAIN, 25));
        bDelete.setBackground(new Color(224, 223, 142));
        bDelete.setPreferredSize(new Dimension(120, 40));

        springLayout.putConstraint(SpringLayout.SOUTH, bBack, -20, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, bBack, -20, SpringLayout.EAST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, bEdit, -20, SpringLayout.NORTH, bDelete);
        springLayout.putConstraint(SpringLayout.EAST, bEdit, -20, SpringLayout.EAST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, bDelete, -20, SpringLayout.NORTH, bBack);
        springLayout.putConstraint(SpringLayout.EAST, bDelete, -20, SpringLayout.EAST, this);
    }
    private void setGrid(){
        gridpanel.setBackground(new Color(0xB0B0EF));
        gridpanel.setLayout(new GridLayout(4, 2, 10, 20));
        gridpanel.add(idL);
        gridpanel.add(idT);
        gridpanel.add(nameL);
        gridpanel.add(nameT);
        gridpanel.add(amountL);
        gridpanel.add(amountT);
        gridpanel.add(priceL);
        gridpanel.add(priceT);

        idL.setFont(new Font("Arial", Font.PLAIN, 20));
        nameL.setFont(new Font("Arial", Font.PLAIN, 20));
        amountL.setFont(new Font("Arial", Font.PLAIN, 20));
        priceL.setFont(new Font("Arial", Font.PLAIN, 20));
        idT.setFont(new Font("Arial", Font.PLAIN, 20));
        nameT.setFont(new Font("Arial", Font.PLAIN, 20));
        amountT.setFont(new Font("Arial", Font.PLAIN, 20));
        priceT.setFont(new Font("Arial", Font.PLAIN, 20));
        idT.setPreferredSize(new Dimension(200, 30));
    }
    public void initialize(){
        nameT.setText("");
        amountT.setText("");
        priceT.setText("");
        idT.setSelectedIndex(-1);
    }
    public void setIds(ArrayList<Products> list) {
        try {
            idT.removeAllItems();
            for (Products products : list) {
                idT.addItem(products.getId());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(10);
        }
    }
    public void setData(Products p){
        nameT.setText(p.getName());
        amountT.setText(String.valueOf(p.getAmount()));
        priceT.setText(String.valueOf(p.getPrice()));
    }
    public String getNameT() {
        return nameT.getText();
    }
    public int getAmount() {
        return Integer.parseInt(amountT.getText());
    }
    public int getPrice() {
        return Integer.parseInt(priceT.getText());
    }
    public int getId() {
        return (int) idT.getSelectedItem();
    }
    public JButton getbBack() {return bBack;}
    public JButton getbEdit() {return bEdit;}
    public JButton getbDelete(){return bDelete;}
    public JComboBox getIdT(){ return idT;}
}
