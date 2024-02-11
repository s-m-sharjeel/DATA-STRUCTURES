package Assignments.Assignment4;

public class Driver {

    public static void main(String[] args) {

        Dictionary d1 = new Dictionary("abc", "def");
        Dictionary d2 = new Dictionary("ghi", "jkl");
        Dictionary d3 = new Dictionary("mno", "pqr");
        Dictionary d4 = new Dictionary("stu", "vwx");
        Dictionary d5 = new Dictionary("", "yz");

        HashTable table = new HashTable(4);

        System.out.println("Inserting " + d1 + " ....");
        table.insert(d1);
        System.out.println("Inserting " + d2 + " ....");
        table.insert(d2);
        System.out.println("Inserting " + d3 + " ....");
        table.insert(d3);
        System.out.println("Inserting " + d4 + " ....");
        table.insert(d4);
        System.out.println("Inserting " + d5 + " ....");
        table.insert(d5);

        System.out.println("\nDisplaying Table:\n ");
        table.display();

        System.out.println("Total number of collisions: " + table.getTotalCollisions());

        System.out.println("Finding 'abc': " + table.getTable()[table.find("abc")]);
        System.out.println("Deleting 'abc': " + table.delete("abc"));

        System.out.println("\nDisplaying Table:\n ");
        table.display();
    }

}
