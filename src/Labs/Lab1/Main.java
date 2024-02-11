package Labs.Lab1;

public class Main {

    public static void main(String[] args) {

        MyArrayList list = new MyArrayList(2);
        list.InsertInOrder(3);
        list.InsertInOrder(6);
        list.InsertInOrder(9);
        list.InsertInOrder(1);

        list.PrintList();
        System.out.println(list.Find(3));
        System.out.println(list.Length());

        list.Remove(1);
        list.PrintList();

    }

}
