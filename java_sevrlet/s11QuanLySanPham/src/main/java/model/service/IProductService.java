package model.service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> list();
    void add(Product product);
    List<Product> findByName(String name);
    void update(int id, Product product);
    void remove(int product);
    Product findById(int id);
}
