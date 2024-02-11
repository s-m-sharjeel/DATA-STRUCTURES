package Labs.Lab5;

public class DoublyLinkedList <T extends Comparable<T>>{

    Node<T> head;

    public DoublyLinkedList() {
        head = null;
    }


    /**
     * inserts a value in the list in ascending order
     * @param value is the data
     */
    public void InsertInOrder(T value) {

        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        if (head.data.compareTo(value) >= 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {

            if (current.next.data.compareTo(value) >= 0) {
                newNode.prev = current;
                newNode.next = current.next;
                current.next.prev = newNode;
                current.next = newNode;
                return;
            }

            current = current.next;
        }

        newNode.prev = current;
        current.next = newNode;

    }

    /**
     * searches for a value in the list
     * @param data is the value to be searched for
     * @return the node of the value found and null if not found
     */
    public Node<T> find(T data){

        Node<T> current = head;

        while (current != null) {

            if (current.data.equals(data))
                return current;

            current = current.next;
        }

        return null;

    }

    /**
     * purges the list
     */
    public void clear(){
        head = null;
    }

    /**
     * deletes the data from the list
     * @param data is the value to be deleted
     */
    public void delete(T data){

        if (head.data.compareTo(data) == 0){

            if (head.next != null)
                head.next.prev = null;

            head = head.next;
            return;
        }

        Node<T> current = head;
        boolean found = false;

        while (current.next != null) {

            if (current.data.equals(data)) {
                found = true;
                break;
            }

            current = current.next;
        }

        if (!found){
            System.out.println("data not found!");
            return;
        }

        if (current.next == null)
            current.prev.next = null;
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

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
     * reverses the order of the list
     */
    public void reverseList(){

        if (length() < 2)
            return;

        Node<T> current = head;
        Node<T> temp;

        while (current != null) {

            temp = current.next;
            current.next = current.prev;
            current.prev = temp;

            if (temp == null){
                head = current;
                break;
            } else
                current = temp;

        }

    }

}
