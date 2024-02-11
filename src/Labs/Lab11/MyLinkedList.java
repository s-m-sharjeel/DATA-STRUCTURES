package Labs.Lab11;

public class MyLinkedList <T extends Comparable<T>>{
    static class Node<T extends Comparable<T>> {

        Node<T> prev;

        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }

    }
    Node<T> head;
    Node<T> tail;

    /**
     * @return true if list is empty and false otherwise
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * @return the length/size of the list (no. of nodes/elements)
     */
    public int length(){

        int i = 0;
        Node<T> current = head;

        while (current != null) {
            i++;
            current = current.next;
        }

        return i;

    }

    /**
     * creates a new node with the integer and adds it to the beginning of the list
     * @param value is the data of the new node
     */
    public void addAsHead(T value){

        Node<T> newNode = new Node<T>(value);

        if (isEmpty()) {
            tail = newNode;
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }

    /**
     * creates a new node with the integer and adds it to the end of the list
     * @param value is the data of the new node
     */
    public void addAsTail(T value){

        Node<T> newNode = new Node<T>(value);

        if (isEmpty()) {
            tail = newNode;
            head = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;

    }

    /**
     * inserts a value in the list in ascending order
     * @param value is the data
     */
    public void addSorted(T value) {

        Node<T> newNode = new Node<T>(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }

        if (head.data.compareTo(value) >= 0) {
            addAsHead(value);
            return;
        }

        if (tail.data.compareTo(value) <= 0) {
            addAsTail(value);
            return;
        }

        Node<T> current = head.next;

        while (current != null) {

            if (current.data.compareTo(value) >= 0) {
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
                return;
            }

            current = current.next;

        }

    }

    /**
     * searches for a value in the list
     * @param data is the value to be searched for
     * @return the node of the value found and null if not found
     */
    public T find(T data) {

        Node<T> current = head;

        while (current != null) {

            if (current.data.equals(data))
                return current.data;

            current = current.next;
        }

        return null;

    }

    /**
     * removes the first node with the given value
     * @param value is the data to be removed
     */
    public void removeFirst(T value) {

        if (isEmpty())  // list is empty
            return;

        // value exists at the head
        if (head.data.equals(value)) {

            head = head.next;

            if (head == null)
                tail = null;
            else
                head.prev = null;

            return;

        }

        // value exists at the tail
        if (tail.data.equals(value)){

            tail = tail.prev;

            if (tail == null)
                head = null;
            else
                tail.next = null;

            return;

        }

        // value exists somewhere in the middle
        Node<T> current = head.next;

        while (current != null) {

            if (current.data.equals(value)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }

            current = current.next;

        }

        // data not found

    }

    public boolean contains(T data) {

//        same functionality as:
//        if (find(data) != null)
//            return true;
//        return false;

        return find(data) != null;

    }

    /**
     * returns the element at index i
     * @param i is the index
     * @return the element at the index i
     */
    public T get(int i) {

        int j = 0;
        Node<T> current = head;

        while (current != null) {

            if (i == j)
                return current.data;

            current = current.next;
            j++;
        }

        return tail.data;

    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("[ ");

        if (head != null) {

            Node<T> current = head;

            while (current.next != null) {
                s.append(current.data).append(", ");
                current = current.next;
            }

            s.append(current.data).append(" ]");

        } else s.append("]");

        return s.toString();

    }

}
