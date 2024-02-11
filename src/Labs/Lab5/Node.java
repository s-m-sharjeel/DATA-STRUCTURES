package Labs.Lab5;

public class Node<T extends Comparable<T>>{

    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

}
