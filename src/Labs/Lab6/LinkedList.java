package Labs.Lab6;

public class LinkedList<T extends Comparable<T>> {

    public class Node <T extends Comparable<T>>{

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

    public Node<T> middleNode() {

        if (isEmpty())
            return null;

        Node<T> fast = head;
        Node<T> slow = head;

        while ((fast != null) && (fast.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    public LinkedList<T> sortedMerge(LinkedList<T> l1, LinkedList<T> l2) {

        if (l1.isEmpty())
            return l2;

        if (l2.isEmpty())
            return l1;

        LinkedList<T> l = new LinkedList<>();

        Node<T> current1 = l1.head;
        Node<T> current2 = l2.head;

        while (current1 != null && current2 != null) {

            if (current1.data.compareTo(current2.data) == 0) {

                l.insert(current1.data);
                l.insert(current2.data);
                current1 = current1.next;
                current2 = current2.next;

            } else if (current1.data.compareTo(current2.data) < 0) {

                l.insert(current1.data);
                current1 = current1.next;

            } else if (current1.data.compareTo(current2.data) > 0) {

                l.insert(current2.data);
                current2 = current2.next;

            }

        }

        while (current1 != null) {
            l.insert(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            l.insert(current2.data);
            current2 = current2.next;
        }

        return l;

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

    public boolean isEmpty() {

        return head == null;

    }

}

