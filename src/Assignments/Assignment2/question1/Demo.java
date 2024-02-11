package Assignments.Assignment3.question1;

public class Demo {

    public static void main(String[] args) {

        DoublyLinkedList DL = new DoublyLinkedList();
        DL.addSorted(8);
        DL.print();
        DL.addSorted(2);
        DL.print();
        DL.addSorted(4);
        DL.print();
        DL.addSorted(2);
        DL.print();
        DL.addSorted(4);
        DL.print();
        DL.addSorted(5);
        DL.print();
        DL.addSorted(4);
        DL.print();
        DL.reverse();
        DL.print();

        System.out.println(DL.head);
        System.out.println(DL.tail);

        DL.removeFirst(10);
        DL.print();

        System.out.println(DL.length());
        DL.addAsHead(1);
        DL.addAsTail(10);
        DL.print();

        System.out.println(DL.find(2));
        System.out.println(DL.find(3));

        DL.reverse();
        DL.print();

        System.out.println(DL.pop());
        System.out.println(DL.pop());
        DL.print();

        DL.removeFirst(2);
        DL.print();

        DL.removeAll(4);
        DL.print();

        DoublyLinkedList l = new DoublyLinkedList();
        l.addSorted(1);
        l.addSorted(2);
        l.addSorted(3);

        DL.addAll(l);
        DL.print();

    }

}
