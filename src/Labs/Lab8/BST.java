package Labs.Lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BST <T extends Comparable<T>>{

    Node<T> root;
    int count;

    public void insert(T key) {

        Node<T> newNode = new Node<T>(key);

        if (root == null) {
            root = newNode;
            count++;
            return;
        }

        Node<T> temp = root;
        Node<T> prev = root;

        while(temp != null){

            prev = temp;

            if (temp.data.compareTo(key) > 0) {
                temp = temp.left;
            } else if (temp.data.compareTo(key) < 0) {
                temp = temp.right;
            } else throw new RuntimeException("similar data found!\neach data must be unique!");

        }

        if (prev.data.compareTo(key) > 0) {
            prev.left = newNode;
        } else if (prev.data.compareTo(key) < 0) {
            prev.right = newNode;
        }

        count++;

    }

    public void traverse(Node<T> n) {

        if (isEmpty())
            throw new RuntimeException("tree is empty!");

        Queue<Node<T>> q = new Queue<>();
        q.enqueue(n);
        while (!q.isEmpty()) {
            Node<T> temp = q.dequeue();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.enqueue(temp.left);
            if (temp.right != null)
                q.enqueue(temp.right);

        }

        System.out.println();
    }

    public Node<T> find(T key) {

        Node<T> temp= root;
        while (temp!=null && key.compareTo(temp.data) != 0){

            if (temp.data.compareTo(key) > 0)
                temp = temp.right;
            else if (temp.data.compareTo(key) < 0)
                temp = temp.left;

        }

        if(temp !=null && key.compareTo(temp.data)==0)
            return temp;

        return null;

    }

    public boolean isEmpty() {

        return root == null;

    }

    public void LNR(Node<T> node) {

        if (node == null)
            return;

        LNR(node.left);
        System.out.print(node.data + " ");
        LNR(node.right);

    }

    public int heightCount(Node<T> node) {

        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 0;

        return Math.max(heightCount(node.left), heightCount(node.right)) + 1;

    }

    public int countTotal(Node<T> node) {

        if (node == null)
            return 0;

        return countTotal(node.left) + countTotal(node.right) + 1;

    }

    public int countLeaf(Node<T> node) {

        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        return countLeaf(node.left) + countLeaf(node.right);

    }

}
