package model.repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepository implements IProductRepository {
    private static List<Product> listProduct = new ArrayList<>();


    static {

        listProduct.add(new Product(1, "IPhone", "Blue", "1"));
        listProduct.add(new Product(2, "IPhone", "Blue", "1"));
        listProduct.add(new Product(3, "IPhone", "Blue", "1"));
        listProduct.add(new Product(4, "IPhone", "Blue", "1"));
        listProduct.add(new Product(5, "IPhone", "Blue", "1"));
    }


    @Override
    public List<Product> list() {
        return listProduct;
    }

    @Override
    public void add(Product product) {
        listProduct.add(product);
    }

    @Override
    public Product findByName(String name) {
        for(Product c:listProduct){
            if (Objects.equals(c.getNameProduct(), name)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void update(int index, Product product) {
        for (int i = 0; i <listProduct.size() ; i++) {
            if (listProduct.get(i).getId() ==index){
                listProduct.set(i,product);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i <listProduct.size() ; i++) {
            if (listProduct.get(i).getId() ==id){
                listProduct.remove(i);
            }
        }
    }

    @Override
    public void seachName(Product product) {

    }

    @Override
    public Product findById(int id) {
        for (Product c:listProduct){
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }
}
