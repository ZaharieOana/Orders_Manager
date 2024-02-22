package PresentationLayer.Panels.Clients;

import Model.Clients;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditClient extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private final JPanel gridpanel = new JPanel();
    private final JLabel title = new JLabel("Edit client");
    private final JLabel idL = new JLabel("ID");
    private final JLabel nameL = new JLabel("Name");
    private final JLabel addressL = new JLabel("Address");
    private final JLabel emailL = new JLabel("Email");
    private final JLabel phoneL = new JLabel("Phone");
    private final JComboBox idT = new JComboBox();
    private final JTextField nameT = new JTextField();
    private final JTextField addressT = new JTextField();
    private final JTextField emailT = new JTextField();
    private final JTextField phoneT = new JTextField();
    private final JButton bBack = new JButton("Back");
    private final JButton bEdit = new JButton("Edit");
    private final JButton bDelete = new JButton("Delete");

    public EditClient(){
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
        gridpanel.setLayout(new GridLayout(5, 2, 10, 20));
        gridpanel.add(idL);
        gridpanel.add(idT);
        gridpanel.add(nameL);
        gridpanel.add(nameT);
        gridpanel.add(addressL);
        gridpanel.add(addressT);
        gridpanel.add(emailL);
        gridpanel.add(emailT);
        gridpanel.add(phoneL);
        gridpanel.add(phoneT);

        idL.setFont(new Font("Arial", Font.PLAIN, 20));
        nameL.setFont(new Font("Arial", Font.PLAIN, 20));
        addressL.setFont(new Font("Arial", Font.PLAIN, 20));
        emailL.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneL.setFont(new Font("Arial", Font.PLAIN, 20));
        idT.setFont(new Font("Arial", Font.PLAIN, 20));
        nameT.setFont(new Font("Arial", Font.PLAIN, 20));
        addressT.setFont(new Font("Arial", Font.PLAIN, 20));
        emailT.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneT.setFont(new Font("Arial", Font.PLAIN, 20));
        nameT.setPreferredSize(new Dimension(200, 30));
    }
    public void initialize(){
        nameT.setText("");
        addressT.setText("");
        emailT.setText("");
        phoneT.setText("");
        idT.setSelectedIndex(-1);
    }

    /**
     * Adauga in lista de optiuni de selectare al id-ului, toate id-urile clientilor din lista trimisa ca parametru
     * @param list lista tuturor clientilor existenti in baza de date
     */
    public void setIds(ArrayList<Clients> list) {
        try {
            idT.removeAllItems();
            for (Clients clients : list) {
                idT.addItem(clients.getId());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(10);
        }
    }
    public void setData(Clients c){
        nameT.setText(c.getName());
        addressT.setText(c.getAddress());
        emailT.setText(c.getEmail());
        phoneT.setText(c.getPhone());
    }
    public String getNameT() {
        return nameT.getText();
    }
    public String getAddressT() {
        return addressT.getText();
    }
    public String getEmailT() {
        return emailT.getText();
    }
    public String getPhoneT() {
        return phoneT.getText();
    }
    public int getId() {
        return (int) idT.getSelectedItem();
    }
    public JButton getbBack() {return bBack;}
    public JButton getbEdit() {return bEdit;}
    public JButton getbDelete(){return bDelete;}
    public JComboBox getIdT(){ return idT;}
}
