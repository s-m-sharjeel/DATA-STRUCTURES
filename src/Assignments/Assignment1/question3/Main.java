package Assignments.Assignment1.question3;

public class Main {

    private static int recursiveCalls;

    public static void main(String[] args) {

        // for n = 4:
        recursiveCalls = 0;
        tower(4, '1', '3', '2');
        System.out.println("total number of calls for n = 4: " + recursiveCalls);

        // for n = 22
//        recursiveCalls = 0;
//        tower(22, '1', '3', '2');
//        System.out.println("total number of calls for n = 22: " + recursiveCalls);

    }

    public static void tower(int n, char s, char t, char des) {

        recursiveCalls++;

        if (n == 1)
            return;

        // Move the top n - 1 disks from s to des using t as a temporary rod
        tower(n - 1, s, des, t);

        // Move the largest disk from s to t
        System.out.println("Move disk " + n + " from needle " + s + " to needle " + t);

        // Move the top n - 1 disks from des to t using s as a temporary rod
        tower(n - 1, des, t, s);

    }

}
