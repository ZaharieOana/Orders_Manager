package PresentationLayer.Panels;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private final JLabel title = new JLabel("Choose what to operate on");
    private final JButton bClient = new JButton("Clients");
    private final JButton bProduct = new JButton("Products");
    private final JButton bOrder = new JButton("Orders");
    public HomePage(){
        setBackground(new Color(0xB0B0EF));
        setLayout(springLayout);
        add(title);
        add(bClient);
        add(bProduct);
        add(bOrder);

        title.setFont(new Font("Arial", Font.PLAIN, 35));
        setButtons();

        springLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bClient, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bProduct, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bOrder, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, bProduct, 0, SpringLayout.VERTICAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.SOUTH, bClient, -30, SpringLayout.NORTH, bProduct);
        springLayout.putConstraint(SpringLayout.NORTH, bOrder, 30, SpringLayout.SOUTH, bProduct);
    }
    private void setButtons(){
        bClient.setFont(new Font("Arial", Font.PLAIN, 25));
        bClient.setBackground(new Color(146, 241, 154));
        bClient.setPreferredSize(new Dimension(150, 50));
        bProduct.setFont(new Font("Arial", Font.PLAIN, 25));
        bProduct.setBackground(new Color(146, 241, 154));
        bProduct.setPreferredSize(new Dimension(150, 50));
        bOrder.setFont(new Font("Arial", Font.PLAIN, 25));
        bOrder.setBackground(new Color(146, 241, 154));
        bOrder.setPreferredSize(new Dimension(150, 50));
    }

    public JButton getbClient() {
        return bClient;
    }
    public JButton getbProduct() {
        return bProduct;
    }
    public JButton getbOrder() {
        return bOrder;
    }
}
