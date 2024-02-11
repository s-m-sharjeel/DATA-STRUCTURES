package Final_Lab;

import java.util.Date;

public class Driver {

    public static void main(String[] args) {

        BST bst = new BST();

        Product p1 = new Product(1234, "chocolate", 50, 100, new Date("12/6,23"), new Date("1/1/24"));
        Product p2 = new Product(2345, "chips", 50, 75, new Date("12/11,23"), new Date("1/12/23"));
        Product p3 = new Product(3456, "drink", 75, 150, new Date("12/6,23"), new Date("1/1/24"));
        Product p4 = new Product(4567, "candy", 10, 300, new Date("12/4,23"), new Date("11/1/23"));
        Product p5 = new Product(5678, "ice cream", 90, 0, new Date("12/6,23"), new Date("11/1/24"));

        System.out.println("Inserting 5 product records...");
        bst.insert(p4);
        bst.insert(p1);
        bst.insert(p3);
        bst.insert(p2);
        bst.insert(p5);

        System.out.println("\nFinding the product with the code 5678...");
        System.out.println(bst.find(5678)); // returns ice cream

        System.out.println("\nListing all expired items:");
        bst.listExpired(bst.root);  // list chips and candy as they're the only items expired

        System.out.println("\nListing all items in stock:");
        bst.listAll(bst.root);  // list all items except ice cream since its stock is zero

    }

}
