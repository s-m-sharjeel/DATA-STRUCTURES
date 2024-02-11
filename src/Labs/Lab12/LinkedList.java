package Labs.Lab12;

public class LinkedList<T> {

    public class Node <T>{

        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<T> head;
    int size;

    public LinkedList() {

        head = null;
        size = 0;

    }

    public void insert(T data){

        if (head == null){
            head = new Node<T>(data);
            return;
        }

        Node<T> current = head;

        while (current.next != null)
            current = current.next;

        current.next = new Node<T>(data);
        size++;

    }

    public Node<T> find(T data){

        Node<T> current = head;

        int i = 0;
        while (current != null) {

            if (current.data.equals(data))
                return current;

            current = current.next;
            i++;
        }

        return null;

    }

    public void clear(){

        head = null;

    }

    public T get(int index) {

        if (head == null)
            return null;

        Node<T> current = head;

        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        return current.data;

    }

    public void delete(T data){

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {

            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

        System.out.println("data not found!");

    }

    public void delete(int index){

        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        int i = 1;

        while (current.next != null) {

            if (i == index) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
            i++;
        }

        System.out.println("data not found!");

    }

    @Override
    public String toString() {


        String s = "[ ";

        if (head != null) {

            Node<T> current = head;

            while (current.next != null) {
                s += current.data + ", ";
                current = current.next;
            }

            s += current.data + " ]";

        } else s += "]";

        return s;

    }

    public boolean contains(T data) {

        return find(data) != null;

    }

}

