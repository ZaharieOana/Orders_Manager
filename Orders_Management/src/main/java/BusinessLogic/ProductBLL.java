package BusinessLogic;

import DataAccess.ProductDAO;
import Model.Products;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProductBLL {
    private final ProductDAO productDAO;
    public ProductBLL(){
        productDAO =new ProductDAO();
    }
    public Products findProductById(int id){
        Products pr = productDAO.findById(id);
        if(pr==null){
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return pr;
    }
    public Products insertProduct(Products product){
        return productDAO.insert(product);
    }
    public ArrayList<Products> findAllProducts(){
        ArrayList<Products> list = productDAO.findAll();
        if(list.isEmpty()){
            System.out.println("No elements in table Products");
        }
        return list;
    }
    public Products updateProduct(Products product){
        Products pr = productDAO.update(product);
        if(pr==null){
            throw new NoSuchElementException("The student couldn't be updated!");
        }
        return pr;
    }
    public boolean deleteProduct(int id){
        boolean del = productDAO.delete(id);
        if(!del){
            throw new NoSuchElementException("The client couldn't be deleted!");
        }
        return del;
    }
}
