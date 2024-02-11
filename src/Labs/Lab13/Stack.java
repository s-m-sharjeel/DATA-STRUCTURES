package Labs.Lab13;

public class Stack<T> {

    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

    }

    private Node<T> head;
    private int size;

    public void push(T data) {

        Node<T> newNode = new Node<>(data);
        size++;

        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    public T pop() {

        if (isEmpty())
            throw new RuntimeException("Stack is Empty!");

        T temp = head.data;
        head = head.next;

        size--;

        return temp;

    }

    public T peek() {

        if (isEmpty())
            throw new RuntimeException("Stack is Empty!");

        return head.data;

    }

    public boolean isEmpty() {

        return head == null;

    }

    public int size() {
        return size;
    }

}
