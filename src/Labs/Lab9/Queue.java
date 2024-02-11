package Labs.Lab9;

public class Queue <T>{

    static class Node<T> {

        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }

    }

    Node<T> front;
    Node<T> rear;

    public void enqueue(T data) {

        Node<T> newNode = new Node<T>(data);

        if (front == null && rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;

    }

    public T dequeue() {

        if (front == null && rear == null)
            return null;

        assert front != null;
        T temp = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return temp;

    }

    public boolean isEmpty() {

        return front == null && rear == null;

    }

}
