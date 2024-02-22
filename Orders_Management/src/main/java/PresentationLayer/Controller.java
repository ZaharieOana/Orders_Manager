package PresentationLayer;

import BusinessLogic.*;
import Model.Bills;
import Model.Clients;
import Model.Orders;
import Model.Products;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Controller {
    private final View view = new View();
    private final ClientBLL clientBLL = new ClientBLL();
    private final ProductBLL productBLL = new ProductBLL();
    private final OrderBLL orderBLL = new OrderBLL();
    private final BillBLL billBLL = new BillBLL();

    /**
     * Seteaza action listeneri pentru toate butoanele din interfata grafica, al caror rezultate au legatura cu baza de date
     */
    Controller(){
        view.getCreateClient().getbCreate().addActionListener(new BtnCreateClient());
        view.getEditClient().getbEdit().addActionListener(new BtnEditClient());
        view.getEditClient().getbDelete().addActionListener(new BtnDeleteClient());
        view.getClients().getbEdit().addActionListener(new BtnGoToEditClients());
        view.getClients().getbViewAll().addActionListener(new BtnGoToViewClients());

        view.getCreateProduct().getbCreate().addActionListener(new BtnCreateProduct());
        view.getEditProducts().getbEdit().addActionListener(new BtnEditProduct());
        view.getEditProducts().getbDelete().addActionListener(new BtnDeleteProduct());
        view.getProducts().getbEdit().addActionListener(new BtnGoToEditProducts());
        view.getProducts().getbViewAll().addActionListener(new BtnGoToViewProducts());

        view.getPlaceOrder().getbCreate().addActionListener(new BtnPlaceOrder());
        view.getOrders().getbOrder().addActionListener(new BtnGoToPlaceOrder());
        view.getOrders().getbOrderView().addActionListener(new BtnViewOrders());
        view.getOrders().getbBill().addActionListener(new BtnViewAllBills());
    }

    private class BtnCreateClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Clients c = new Clients(view.getCreateClient().getNameClient(), view.getCreateClient().getAddress(), view.getCreateClient().getEmail(), view.getCreateClient().getPhone());
            clientBLL.insertClient(c);
            view.getCreateClient().initialize();
        }
    }
    private class BtnCreateProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Products p = new Products(view.getCreateProduct().getNameProduct(), view.getCreateProduct().getAmount(), view.getCreateProduct().getPrice());
            productBLL.insertProduct(p);
            view.getCreateProduct().initialize();
        }
    }
    private class BtnEditClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Clients client = new Clients(view.getEditClient().getId(), view.getEditClient().getNameT(), view.getEditClient().getAddressT(), view.getEditClient().getEmailT(), view.getEditClient().getPhoneT());
            clientBLL.updateClient(client);
            view.getEditClient().initialize();
        }
    }
    private class BtnEditProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Products product = new Products(view.getEditProducts().getId(), view.getEditProducts().getNameT(), view.getEditProducts().getAmount(), view.getEditProducts().getPrice());
            productBLL.updateProduct(product);
            view.getEditProducts().initialize();
        }
    }
    private class BtnDeleteClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            clientBLL.deleteClient(view.getEditClient().getId());
            view.getEditClient().setIds(clientBLL.findAllClients());
            view.getEditClient().initialize();
        }
    }
    private class BtnDeleteProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            productBLL.deleteProduct(view.getEditProducts().getId());
            view.getEditProducts().setIds(productBLL.findAllProducts());
            view.getEditProducts().initialize();
        }
    }
    private class BtnGoToEditClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getEditClient().setIds(clientBLL.findAllClients());
            view.getEditClient().initialize();
            view.getEditClient().getIdT().addItemListener(new IdChangeClient());
            view.goToEditClient();
        }
    }

    /**
     * In panel-ul de editare a unui client, la selectia unui anumit id, se vor completa automat campurile cu datele clientului, care vor putea fi modificate
     */
    class IdChangeClient implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int idd = (int) view.getEditClient().getIdT().getSelectedItem();
                view.getEditClient().setData(clientBLL.findClientById(idd));
            }
        }
    }
    private class BtnGoToEditProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getEditProducts().setIds(productBLL.findAllProducts());
            view.getEditProducts().initialize();
            view.getEditProducts().getIdT().addItemListener(new IdChangeProduct());
            view.goToEditProducts();
        }
    }

    /**
     * In panel-ul de editare a unui produs, la selectia unui anumit id, se vor completa automat campurile cu datele produsului, care vor putea fi modificate
     */
    class IdChangeProduct implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int idd = (int) view.getEditProducts().getIdT().getSelectedItem();
                view.getEditProducts().setData(productBLL.findProductById(idd));
            }
        }
    }
    private class BtnGoToViewClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getViewClients().setClients(clientBLL.findAllClients());
            view.goToViewClients();
        }
    }
    private class BtnGoToViewProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getViewProducts().setProducts(productBLL.findAllProducts());
            view.goToViewProducts();
        }
    }
    private class BtnGoToPlaceOrder implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getPlaceOrder().setClients(clientBLL.findAllClients());
            view.getPlaceOrder().setProducts(productBLL.findAllProducts());
            view.getPlaceOrder().initialize();
            view.goToPlaceOrder();
        }
    }

    /**
     * La plasarea unei comenzi se verifica daca cntitatea de produs ceruta este disponibila.
     * Daca nu, se va afisa un mesaj de atentionare. Altfel, se fa plasa comanda.
     * Dupa plasarea comenzii, cantitatea produsului comandat se va decrementa.
     * Se va crea o factura pentru comanda plasata.
     */
    private class BtnPlaceOrder implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Products p = productBLL.findProductById(view.getPlaceOrder().getProductId());
            int amount = view.getPlaceOrder().getAmount();
            if(amount>p.getAmount())
                view.getPlaceOrder().getWarnig().setVisible(true);
            else {
                int sum = (p.getPrice()) * amount;
                Orders o = new Orders(view.getPlaceOrder().getClientId(), view.getPlaceOrder().getProductId(), amount, sum);
                orderBLL.insertOrders(o);
                view.getPlaceOrder().initialize();
                p.setAmount(p.getAmount()-amount);
                productBLL.updateProduct(p);
                Bills b = new Bills(0, sum);
                billBLL.insertBill(b);
            }
        }
    }
    private class BtnViewOrders implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getViewOrders().setOrders(orderBLL.findAllOrders());
            view.goToViewOrders();
        }
    }
    private class BtnViewAllBills implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getViewBills().setBills(billBLL.findAllBills());
            view.goToViewBills();
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }
}
