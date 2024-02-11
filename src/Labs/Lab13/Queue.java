package Labs.Lab13;

public class Queue<T> {

    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public void enqueue(T data) {

        Node<T> newNode = new Node<>(data);
        size++;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;

    }

    public T dequeue() {

        if (isEmpty())
            throw new RuntimeException("Queue is Empty!");

        T temp = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        size--;

        return temp;

    }

    public boolean isEmpty() {

        return front == null && rear == null;

    }

    public int size() {
        return size;
    }

}
