package DataAccess;

import Model.Products;

public class ProductDAO extends AbstractDAO<Products>{
    public ProductDAO() {
        super(Products.class);
    }
}
