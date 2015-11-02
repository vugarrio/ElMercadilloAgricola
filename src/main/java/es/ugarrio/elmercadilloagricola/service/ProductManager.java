package es.ugarrio.elmercadilloagricola.service;

import java.io.Serializable;
import java.util.List;

import es.ugarrio.elmercadilloagricola.domain.Product;

public interface ProductManager extends Serializable {

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();

}