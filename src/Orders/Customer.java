package Orders;

import java.util.Random;

public class Customer {
    private String name;
    private Long id;
    private int tier;

    Random rand = new Random();
    public Customer(String name) {
        this.name = name;
        this.id = rand.nextLong(10000, 9999999);
        this.tier = rand.nextInt(4) + 1;
    }

    public Customer(String name, int tier) {
        this.name = name;
        this.id = rand.nextLong(10000, 9999999);
        this.tier = tier;
    }

    // getter
    public String getName(){ return name; }
    public Long getId(){ return id; }
    public int getTier(){ return tier; }

    //setter
    public void setTier(int tier){ this.tier = tier; }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", id=" + getId() +
                ", tier=" + getTier() +
                '}';
    }
}
