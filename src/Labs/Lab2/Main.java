public class Main {
    public static void main(String[] args) {

        // question 1
        MyArrayList list = new MyArrayList(2);
        list.InsertInOrder(3);
        list.InsertInOrder(6);
        list.InsertInOrder(9);
        list.InsertInOrder(1);
        list.InsertInOrder(1);

        list.PrintList();
        System.out.println(list.Find(3));
        System.out.println(list.Length());

        list.Remove(1);
        list.PrintList();

        // question 2
        MyArrayList students = new MyArrayList();
        Student student1 = new Student("ali", 20, 3.50f);
        Student student2 = new Student("sharjeel", 18, 3.85f);
        Student student3 = new Student("ahmed", 19, 3.75f);
        students.InsertInOrder(student1);
        students.InsertInOrder(student2);
        students.InsertInOrder(student3);

        System.out.println(students.Find(student1));

        // question 3
        System.out.println(students.findMax());
        students.PrintList();


    }
}
