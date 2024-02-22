package PresentationLayer.Panels.Clients;

import Model.Clients;
import Model.Products;
import PresentationLayer.TabelGenerator;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ViewClients extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private final JPanel scrollPanel = new JPanel();
    private final JLabel title = new JLabel("View all clients");
    private final JButton bBack = new JButton("Back");

    public ViewClients(){
        setBackground(new Color(0xB0B0EF));
        setLayout(springLayout);
        add(title);
        add(scrollPanel);
        add(bBack);

        scrollPanel.setLayout(new CardLayout());

        title.setFont(new Font("Arial", Font.PLAIN, 35));
        springLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollPanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPanel, 30, SpringLayout.SOUTH, title);
        springLayout.putConstraint(SpringLayout.WEST, scrollPanel, 20, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.EAST, scrollPanel, -20, SpringLayout.EAST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, scrollPanel, -80, SpringLayout.SOUTH, this);

        bBack.setFont(new Font("Arial", Font.PLAIN, 25));
        bBack.setBackground(new Color(224, 223, 142));
        bBack.setPreferredSize(new Dimension(100, 40));

        springLayout.putConstraint(SpringLayout.SOUTH, bBack, -20, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, bBack, -20, SpringLayout.EAST, this);
    }
    public void setClients(ArrayList<Clients> list){
            JTable table = new TabelGenerator<Clients>().setTable(list);
            JScrollPane jScrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPanel.removeAll();
            scrollPanel.add(jScrollPane);
    }
    public JButton getbBack() {
        return bBack;
    }
}
