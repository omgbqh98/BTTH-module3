package model;

public class Product {
    int idProduct;
    String price;
    String amount;
    String color;
    String des;
    int idCategory;
    String nameProduct;

    public Product() {
    }

    public Product(int idProduct, String price, String amount, String color, String des, String nameProduct) {
        this.idProduct = idProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.des = des;
        this.nameProduct = nameProduct;
    }

    public Product(String price, String amount, String color, String des, int idCategory, String nameProduct) {
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.des = des;
        this.idCategory = idCategory;
        this.nameProduct = nameProduct;
    }

    public Product(int idProduct, String price, String amount, String color, String des, int idCategory, String nameProduct) {
        this.idProduct = idProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.des = des;
        this.idCategory = idCategory;
        this.nameProduct = nameProduct;
    }

    public Product(int idProduct, String nameProduct, String price, String amount, String color, String des, int idCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.des = des;
        this.idCategory = idCategory;
    }

    public Product(int idProduct, String price, String amount, String color, String des, int idCategory) {
        this.idProduct = idProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.des = des;
        this.idCategory = idCategory;

    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Product(String price, String amount, String color, String des) {
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.des = des;
    }

    public Product(int idProduct, String price, String amount, String color, String des) {
        this.idProduct = idProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.des = des;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
