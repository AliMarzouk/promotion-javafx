package javacode.models;

public class Promotion {
    public Promotion(String brand, String product, String description, String imagePath, String logoPath, String category, float price) {
        this.brand = brand;
        this.product = product;
        this.description = description;
        this.imagePath = imagePath;
        this.logoPath = logoPath;
        this.category = category;
        this.price = price;
    }

    private String brand;
    private String product;
    private String description;
    private String imagePath;
    private String logoPath;
    private String category;
    private float price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
