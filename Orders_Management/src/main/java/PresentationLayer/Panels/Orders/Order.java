package PresentationLayer.Panels.Orders;

import javax.swing.*;
import java.awt.*;

public class Order extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private final JLabel title = new JLabel("Operations on orders");
    private final JButton bOrder = new JButton("Place a new order");
    private final JButton bOrderView = new JButton("View orders");
    private final JButton bBill = new JButton("View existing bills");
    private final JButton bBack = new JButton("Back");
    public Order(){
        setBackground(new Color(0xB0B0EF));
        setLayout(springLayout);
        add(title);
        add(bOrder);
        add(bOrderView);
        add(bBill);
        add(bBack);

        title.setFont(new Font("Arial", Font.PLAIN, 35));
        setButtons();

        springLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bOrder, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bOrderView, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bBill, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.SOUTH, bOrder, -30, SpringLayout.NORTH, bOrderView);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, bOrderView, 0, SpringLayout.VERTICAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, bBill, 30, SpringLayout.SOUTH, bOrderView);
        springLayout.putConstraint(SpringLayout.SOUTH, bBack, -20, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, bBack, -20, SpringLayout.EAST, this);
    }
    private void setButtons(){
        bOrder.setFont(new Font("Arial", Font.PLAIN, 25));
        bOrder.setBackground(new Color(146, 241, 154));
        bOrder.setPreferredSize(new Dimension(250, 50));
        bOrderView.setFont(new Font("Arial", Font.PLAIN, 25));
        bOrderView.setBackground(new Color(146, 241, 154));
        bOrderView.setPreferredSize(new Dimension(250, 50));
        bBill.setFont(new Font("Arial", Font.PLAIN, 25));
        bBill.setBackground(new Color(146, 241, 154));
        bBill.setPreferredSize(new Dimension(250, 50));
        bBack.setFont(new Font("Arial", Font.PLAIN, 25));
        bBack.setBackground(new Color(224, 223, 142));
        bBack.setPreferredSize(new Dimension(100, 40));
    }

    public JButton getbOrder() {
        return bOrder;
    }
    public JButton getbOrderView() {
        return bOrderView;
    }
    public JButton getbBill() {
        return bBill;
    }
    public JButton getbBack() {
        return bBack;
    }
}
