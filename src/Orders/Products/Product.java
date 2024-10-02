package Orders.Products;

import com.github.javafaker.Faker;

import java.util.Random;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private  String category;
    Random rand  = new Random();
    Faker faker = new Faker();
    String[] categories = new String[]{"book", "cd", "vinile", "giradischi", "baby", "boys"};

    public Product(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.id = rand.nextLong(10000, 9999999);
    }

    public Product(){
        this.id = rand.nextLong(10000, 9999999);
        this.price = (double) Math.round(rand.nextDouble(1, 1000) * 100.0) / 100.0;
        this.name = faker.book().title();
        this.category = categories[rand.nextInt(categories.length)];
    }

    // getter
    public Long getId() {return id;}
    public Double getPrice() {return price;}
    public String getCategory() {return category;}
    public String getName() {return name;}

    // setter
    public void setId(Long id) {this.id = id;}
    public void setPrice(Double price) {this.price = price;}
    public void setCategory(String category) {this.category = category;}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", category='" + getCategory() + '\'' +
                '}';
    }
}
