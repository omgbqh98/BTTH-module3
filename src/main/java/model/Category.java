package model;

public class Category {
    int idCategory;
    String category;

    public Category(int idCategory, String category) {
        this.idCategory = idCategory;
        this.category = category;
    }

    public Category() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
