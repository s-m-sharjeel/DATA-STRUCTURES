package Assignments.Assignment1.question1;

public class Main {

    public static void main(String[] args) {

        int[] Arr = new int[229];

        for (int i = 0; i < Arr.length; i++)
            Arr[i] = i - 98;    // numbers start from -98

        // prints all the addresses with the value and its index
        for (int i = 0; i < Arr.length; i++) {
            System.out.print(i + ": "); // prints index of the element
            System.out.print(Arr[i]);   // prints the element
            System.out.println(" (" + (348 + (4 * i)) + ")");   // prints the memory address of each element with it
        }

    }

}
