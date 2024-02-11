package Final_Lab;

import java.util.Date;

public class Product implements Comparable<Product> {

    private final int code;
    private final String name;
    private final float price;
    private final int stock;
    private final Date received;
    private final Date expiry;

    public Product(int code, String name, float price, int stock, Date received, Date expiry) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.received = received;
        this.expiry = expiry;
    }

    public int getCode() {
        return code;
    }

    public int getStock() {
        return stock;
    }

    public Date getExpiry() {
        return expiry;
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.code, o.code);
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", received=" + received +
                ", expiry=" + expiry +
                '}';
    }
}
