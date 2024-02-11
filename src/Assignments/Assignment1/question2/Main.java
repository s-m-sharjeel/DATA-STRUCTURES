package Assignments.Assignment1.question2;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>(2);

        // part 1:
        System.out.println("isEmpty: " + list.isEmpty());
        list.InsertInOrder(3);
        list.InsertInOrder(6);
        list.InsertInOrder(9);
        list.InsertInOrder(1);
        list.InsertInOrder(1);
        System.out.println("isEmpty: " + list.isEmpty());

        // part 2:
        System.out.println("length: " + list.length());

        // part 3:
        System.out.print("print: ");
        list.print();

        // part 4:
        list.addAtFront(5);
        System.out.print("add at front: ");
        list.print();

        // part 5:
        list.addAtEnd(3);
        System.out.print("add at end: ");
        list.print();

        // part 6:
        System.out.println("find: " + list.find(1));

        // part 7:
        list.reverse();
        System.out.print("reverse: ");
        list.print();

        // part 8:
        list.removeFirst(3);
        System.out.print("remove first: ");
        list.print();

        // part 9:
        list.removeAll(1);
        System.out.print("remove all: ");
        list.print();

        // part 10:
        MyArrayList<Student> students = new MyArrayList<Student>();
        Student student1 = new Student("ali", "27962", 20);
        Student student2 = new Student("sharjeel", "26932", 18);
        Student student3 = new Student("ahmed", "19757", 19);
        students.InsertInOrder(student1);
        students.InsertInOrder(student2);
        students.InsertInOrder(student3);

        students.print();


    }
}
