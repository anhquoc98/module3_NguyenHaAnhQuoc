package model.service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> list();
    void add(Product product);
    Product findByName(String name);
    void update(Product product);
    void remove(Product product);
    void seachId(Product product);
    Product findById(int id);
}
