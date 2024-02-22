package PresentationLayer.Panels.Clients;

import javax.swing.*;
import java.awt.*;

public class CreateClient extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private final JPanel gridpanel = new JPanel();
    private final JLabel title = new JLabel("Create a client");
    private final JLabel nameL = new JLabel("Name");
    private final JLabel addressL = new JLabel("Address");
    private final JLabel emailL = new JLabel("Email");
    private final JLabel phoneL = new JLabel("Phone");
    private final JTextField nameT = new JTextField();
    private final JTextField addressT = new JTextField();
    private final JTextField emailT = new JTextField();
    private final JTextField phoneT = new JTextField();
    private final JButton bBack = new JButton("Back");
    private final JButton bCreate = new JButton("Create");

    public CreateClient(){
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
        gridpanel.add(addressL);
        gridpanel.add(addressT);
        gridpanel.add(emailL);
        gridpanel.add(emailT);
        gridpanel.add(phoneL);
        gridpanel.add(phoneT);

        nameL.setFont(new Font("Arial", Font.PLAIN, 20));
        addressL.setFont(new Font("Arial", Font.PLAIN, 20));
        emailL.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneL.setFont(new Font("Arial", Font.PLAIN, 20));
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
    }
    public JButton getbBack() {
        return bBack;
    }
    public JButton getbCreate() {
        return bCreate;
    }
    public String getNameClient(){ return nameT.getText();}
    public String getAddress(){ return addressT.getText();}
    public String getEmail(){ return emailT.getText();}
    public String getPhone(){ return phoneT.getText();}
}
