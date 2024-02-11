package question1;

import java.io.IOException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws IOException {

        BST<Integer> bst = new BST<>();

        bst.insert(11);
        bst.insert(15);
        bst.insert(5);
        bst.insert(2);
        bst.insert(10);
        bst.insert(24);

        // question 1:

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the lower limit: ");
        int k1 = input.nextInt();
        System.out.print("Please enter the upper limit: ");
        int k2 = input.nextInt();

        if (k1 > k2)
            throw new RuntimeException("the lower limit is greater than the upper limit of the range!");

        // in-class generic function
        System.out.println("printRange: ");
        bst.printRange(bst.getRoot(), k1, k2);

        // static function in driver class
        System.out.println("printRange: ");
        printRange(bst.getRoot(), k1, k2);

    }

    public static void printRange(Node<Integer> node, int k1, int k2) {

        if (node == null)
            return;

        if (node.data < k1) {
            printRange(node.right, k1, k2);
            return;
        }

        if (node.data > k2) {
            printRange(node.left, k1, k2);
            return;
        }

        printRange(node.left, k1, k2);
        System.out.println(node.data);
        printRange(node.right, k1, k2);

    }

}
