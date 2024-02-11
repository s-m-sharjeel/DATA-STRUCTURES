package Labs.Lab6;

public class Game {

    public class Node {

        String name;
        Node next;

        public Node(String name) {
            this.name = name;
        }

    }

    private Node tail;
    private int size = 0;

    public Game() {
        tail = null;
    }

    public void insertPlayer(String player) {

        Node newNode = new Node(player);

        // if list is empty
        if (isEmpty()) {

            tail = newNode;
            tail.next = newNode;
            size++;
            return;

        }

        // add new node before tail
        newNode.next = tail.next;
        tail.next = newNode;

        // set new node as tail
        tail = newNode;

        size++;

    }

    public String playGame() {

        Node current = tail.next;
        int r = 2 + (int)(Math.random() * 9);  // generates random number between 2 and 10

        while (size > 1) {

            for (int i = 0; i < (r - 2); i++)
                current = current.next;


            Node temp = current.next.next;
            current.next = temp;
            current = temp;
            size--;

        }

        return current.name;

    }

    @Override
    public String toString() {
        Node current = tail.next;
        String s = "";
        for (int i = 0; i < size; i++) {
            if (i == (size - 1))
                s += current.name;
            else s += (current.name + " -> ");
            current = current.next;
        }
        return s;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int length() {
        return size;
    }

}
