package model.repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> list();
    void add(Product product);
    Product findByName(String name);
    void update(int index,Product product);
    void remove(Product product);
    void seachName(Product product);
    Product findById(int id);
}
