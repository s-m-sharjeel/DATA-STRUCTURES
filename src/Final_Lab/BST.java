package Final_Lab;

import java.util.Date;

public class BST {

    public static class Node {

        Product product;
        Node right;
        Node left;

        public Node(Product product) {
            this.product = product;
        }
    }

    Node root;

    /**
     * inserts a product in the bst
     * @param product is the product
     */
    public void insert(Product product) {

        Node newNode = new Node(product);

        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node prev = null;
        Node current = root;

        while (current != null) {

            prev = current;

            if (product.compareTo(current.product) > 0)
                current = current.right;
            else if (product.compareTo(current.product) < 0)
                current = current.left;
            else throw new RuntimeException("a product with the same code already exists!");

        }

        assert prev != null;
        if (product.compareTo(prev.product) > 0)
            prev.right = newNode;
        else if (product.compareTo(prev.product) < 0)
            prev.left = newNode;
        else throw new RuntimeException("a product with the same code already exists!");

    }

    public Product find(int code) {

        if (isEmpty())
            throw new RuntimeException("no product record exists!");


        Node current = root;

        while (current != null) {

            if (code > current.product.getCode())
                current = current.right;
            else if (code < current.product.getCode())
                current = current.left;
            else return current.product;

        }

        // product with the given code not found
        return null;

    }

    public boolean isEmpty() {

        return root == null;

    }

    /**
     * uses LNR traversal to list all items (sorted w.r.t their code)
     * @param node is used to traverse using recursion
     */
    public void listAll(Node node) {

        if (node == null)
            return;

        listAll(node.left);

        if (node.product.getStock() > 0)
            System.out.println(node.product);

        listAll(node.right);

    }

    public void listExpired(Node node) {

        if (node == null)
            return;

        listExpired(node.left);

        long expiryTime = node.product.getExpiry().getTime();
        long currentTime = new Date().getTime();
        if (expiryTime < currentTime)
            System.out.println(node.product);

        listExpired(node.right);

    }

}
