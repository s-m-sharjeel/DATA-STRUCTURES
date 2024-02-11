package Labs.Lab10;

public class LinkedList<T> {

    public class Node<T>{

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

    public LinkedList() {

        head = null;

    }

    public void insert(T data){

        Node<T> newNode = new Node<T>(data);

        if (head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

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

    public boolean isEmpty(){

        return head == null;

    }

    public void delete(T data){

        if (head.next == null){
            if (head.data.equals(data))
                head = null;
            else System.out.println("data not found!");
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


}
