package Orders;

import Orders.Products.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private Long _id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    Random rand = new Random();

    public Order(Customer customer, List<Product> products) {
        this._id = rand.nextLong(10000, 9999999);
        this.customer = customer;
        this.products = products;
        this.orderDate = LocalDate.now().minusDays(rand.nextInt(99999999));
        this.deliveryDate = LocalDate.now().plusDays(1);
        this.status = "in preparazione";
    }

    public Order(Customer customer, List<Product> products, LocalDate deliveryDate) {
        this.customer = customer;
        this._id = rand.nextLong(10000, 9999999);
        this.products = products;
        this.orderDate = LocalDate.now();
        this.deliveryDate = deliveryDate;
        this.status = "in preparazione";
    }

    public Order(Customer customer, List<Product> products, String status) {
        this.customer = customer;
        this.products = products;
        this._id = rand.nextLong(10000, 9999999);
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now().plusDays(1);
        this.status = status;
    }

    // getter
    public Long get_id() {
        return _id;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<Product> getProducts() {
        return products.stream().toList();
    }

    // setter
    public void set_id(Long id) {
        this._id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        setDeliveryDate(orderDate.plusDays(1));
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "_id=" + get_id() +
                ", status='" + getStatus() + '\'' +
                ", orderDate=" + getOrderDate() +
                ", deliveryDate=" + getDeliveryDate() +
                ", products=" + this.products +
                ", customer=" + this.customer +
                '}';
    }
}
