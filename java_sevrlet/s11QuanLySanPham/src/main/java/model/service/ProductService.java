package model.service;

import model.Product;
import model.repository.IProductRepository;
import model.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> list() {
        return productRepository.list();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public void seachId(Product product) {

    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
