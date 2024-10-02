import Orders.Customer;
import Orders.Order;
import Orders.Products.Product;
import com.github.javafaker.Faker;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ITALY);
        Random rand = new Random();
        List<Order> orders = new ArrayList<Order>();
        for (int i = 0; i < 5; i++) {
            Customer cust = new Customer(faker.name().firstName());
            List<Product> products = new LinkedList<Product>();
            for (int j = 0; j < rand.nextInt(4); j++) {
                Product p = new Product();
                products.add(p);
            }
            Order ord = new Order(cust,products );
            orders.add(ord);
        }
        orders.forEach(System.out::println);

    }
}