package Labs.Lab5;

public class Demo {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> DL1=new DoublyLinkedList<Integer>();
        DoublyLinkedList<String> DL2=new DoublyLinkedList<String>();
        DoublyLinkedList<Student> DL3=new DoublyLinkedList<Student>();

        // DL1
        System.out.println(DL1.isEmpty());
        DL1.InsertInOrder(2);
        DL1.InsertInOrder(0);
        DL1.InsertInOrder(1);
        DL1.InsertInOrder(5);
        System.out.println(DL1.isEmpty());
        System.out.println(DL1.length());

        System.out.println(DL1);

        System.out.println(DL1.find(1));

        DL1.delete(0);
        System.out.println(DL1);

        DL1.reverseList();
        System.out.println(DL1);

        DL1.clear();
        System.out.println(DL1);

        // DL2
        System.out.println(DL2.isEmpty());
        DL2.InsertInOrder("abcd");
        DL2.InsertInOrder("fdsf");
        DL2.InsertInOrder("erwf");
        DL2.InsertInOrder("ufgh");
        DL2.InsertInOrder("wfds");
        System.out.println(DL2.isEmpty());

        System.out.println(DL2);

        System.out.println(DL2.find("erwf"));

        DL2.delete("ufgh");
        System.out.println(DL2);

        DL2.reverseList();
        System.out.println(DL2);

        DL2.clear();
        System.out.println(DL2);

        // DL3
        System.out.println(DL3.isEmpty());
        Student student1 = new Student("roohallah", 27082);
        Student student2 = new Student("sharjeel", 26932);
        Student student3 = new Student("shahzain", 26937);
        Student student4 = new Student("xyz", 10000);

        DL3.InsertInOrder(student1);
        DL3.InsertInOrder(student2);
        DL3.InsertInOrder(student3);
        DL3.InsertInOrder(student4);
        System.out.println(DL3.isEmpty());

        System.out.println(DL3);

        System.out.println(DL3.find(student1));

        DL3.delete(student4);
        System.out.println(DL3);

        DL3.reverseList();
        System.out.println(DL3);

        DL3.clear();
        System.out.println(DL3);

    }

}
