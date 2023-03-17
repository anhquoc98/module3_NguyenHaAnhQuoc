package model.repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> list();
    void add(Product product);
    List<Product> findByName(String name);
    void update(int index,Product product);
    void remove(int id);
    Product findById(int id);
}
