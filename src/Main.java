import Orders.Customer;
import Orders.Order;
import Orders.Products.Product;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("---------------> LISTA ORDINI <--------------");
        Faker faker = new Faker(Locale.ITALY);
        Random rand = new Random();
        List<Order> orders = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Product> products = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            Customer cust = new Customer(faker.name().firstName());
            customers.add(cust);
        }

        for (int j = 0; j < 100 + 1; j++) {
            Product p = new Product();
            products.add(p);
        }

        for (int i = 0; i < 50; i++) {

            List<Product> randomProducts = new LinkedList<>();
            for(int j = 0; j < 6; j++) {
                Product p = products.get(rand.nextInt(products.size()));
                randomProducts.add(p);
            }
            Order ord = new Order(customers.get(rand.nextInt(customers.size())), randomProducts);
            orders.add(ord);
        }
        orders.forEach(System.out::println);

        System.out.println("---------------> Prodotti Books <--------------");

        Predicate<Product> searchBooks = product -> product.getCategory().equals("book");
        Predicate<Product> searchBaby = product -> product.getCategory().equals("baby");
        Predicate<Product> searchBoys = product -> product.getCategory().equals("boys");

        Set<Product> booksProd = new HashSet<>();

        orders.stream().map(Order::getProducts).forEach(booksProd::addAll);
        booksProd.stream().filter(searchBooks).forEach(System.out::println);
        System.out.println("Totali -> " + booksProd.size());

        System.out.println("---------------> Ordini Baby <--------------");
        List<Order> babyOrder;

        babyOrder = orders.stream().filter(prod -> prod.getProducts().stream().anyMatch(searchBaby)).collect(Collectors.toList());
        babyOrder.forEach(System.out::println);
        System.out.println("---------------> Prodotti Boys <--------------");
        Set<Product> boysProd = new HashSet<Product>();


        orders.stream().forEach(prod -> prod.getProducts().stream().filter(searchBoys).forEach(boysProd::add));
        System.out.println("--------------PRIMA----------");
        boysProd.forEach(System.out::println);
        boysProd.stream().forEach(prod -> {
            Double changedPrice = (prod.getPrice() - prod.getPrice() * 0.2);
            changedPrice = Math.round(changedPrice * 100) / 100.0;
            prod.setPrice(changedPrice);
        });
        System.out.println("--------------DOPO----------");
        boysProd.forEach(System.out::println);

        System.out.println("---------------> Prodotti tier <--------------");
        for (int i = 0; i < 6; i++) {
            Order ord ;
            ord = orders.get(rand.nextInt(orders.size()));
            if(i % 2 == 0)
                ord.getCustomer().setTier(2);


            ord.setOrderDate(LocalDate.of(2021,2,1).plusDays(rand.nextInt(56)));
        }
        List<Order> filtOrd = new ArrayList<>();

        orders.stream().filter(ord -> ord.getOrderDate().isAfter(LocalDate.of(2021,2,1)) && ord.getOrderDate().isBefore(LocalDate.of(2021,4,1))).forEach(filtOrd::add);
        filtOrd.stream().filter(order -> order.getCustomer().getTier() == 2).forEach(System.out::println);
    }
}