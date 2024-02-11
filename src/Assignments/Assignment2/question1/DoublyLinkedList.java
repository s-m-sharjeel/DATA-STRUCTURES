package Assignments.Assignment3.question1;

public class DoublyLinkedList {
    static class Node {

        Node prev;

        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

    }
    Node head;
    Node tail;

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
        Node current = head;

        while (current != null) {
            i++;
            current = current.next;
        }

        return i;

    }

    /**
     * prints the elements of the list enclosed by square brackets and separated by commas
     */
    public void print(){
        System.out.println(this);
    }

    /**
     * creates a new node with the integer and adds it to the beginning of the list
     * @param value is the data of the new node
     */
    public void addAsHead(int value){

        Node newNode = new Node(value);

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
    public void addAsTail(int value){

        Node newNode = new Node(value);

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
    public void addSorted(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }

        if (head.data >= value) {
            addAsHead(value);
            return;
        }

        if (tail.data <= value) {
            addAsTail(value);
            return;
        }

        Node current = head.next;

        while (current != null) {

            if (current.data >= value) {
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
    public Node find(int data) {

        Node current = head;

        while (current != null) {

            if (current.data == data)
                return current;

            current = current.next;
        }

        return null;

    }

    /**
     * reverses the order of the list
     */
    public void reverse() {

        if (length() <= 1)
            return;

        Node current = head;
        Node temp;

        while (current != null) {

            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;

        }

        temp = head;
        head = tail;
        tail = temp;

    }

    /**
     * returns the value of the head of the list and removes the node, if the list is
     * nonempty, otherwise returns -1
     * @return the value of the head
     */
    public int pop(){

        if (isEmpty())
            return -1;

        int data = head.data;

        head = head.next;

        if (head == null)
            tail = null;
        else
            head.prev = null;

        return data;

    }

    /**
     * removes the first node with the given value
     * @param value is the data to be removed
     */
    public void removeFirst(int value) {

        if (isEmpty())  // list is empty
            return;

        // value exists at the head
        if (head.data == value) {

            head = head.next;

            if (head == null)
                tail = null;
            else
                head.prev = null;

            return;

        }

        // value exists at the tail
        if (tail.data == value){

            tail = tail.prev;

            if (tail == null)
                head = null;
            else
                tail.next = null;

            return;

        }

        // value exists somewhere in the middle
        Node current = head.next;

        while (current != null) {

            if (current.data == value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }

            current = current.next;

        }

        // data not found

    }

    /**
     * removes all occurrences of the given value
     * @param value is the data to be removed
     */
    public void removeAll(int value) {

        while (find(value) != null)
            removeFirst(value);

    }

    /**
     * appends the list l to the last element of the current list, if the current
     * list is nonempty, or lets the head of the current list point to the first element of l if the
     * current list is empty
     * @param list is the list to be appended
     */
    public void addAll(DoublyLinkedList list) {

        if (list.isEmpty())
            return;

        if (isEmpty()) {
            head = list.head;
            tail = list.tail;
            return;
        }

        this.tail.next = list.head;
        list.head.prev = this.tail;
        this.tail = list.tail;

    }

    /**
     * purges the list
     */
    public void clear(){
        head = null;
        tail = null;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("[ ");

        if (head != null) {

            Node current = head;

            while (current.next != null) {
                s.append(current.data).append(", ");
                current = current.next;
            }

            s.append(current.data).append(" ]");

        } else s.append("]");

        return s.toString();

    }

}
