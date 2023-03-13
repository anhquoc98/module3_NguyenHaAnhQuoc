package model;

public class Product {
    private Integer id;
    private String nameProduct;
    private String color;
    private String price;

    public Product() {
    }

    public Product(Integer id, String nameProduct, String color, String price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.color = color;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
