package es.ugarrio.elmercadilloagricola.repository;

import java.util.List;

import es.ugarrio.elmercadilloagricola.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}