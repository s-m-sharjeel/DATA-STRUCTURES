package Assignments.Assignment1.question4;

public class Main {

    public static void main(String[] args) {

        TwoDimensionalDynamicArray arr1 = new TwoDimensionalDynamicArray(3, 3);
        arr1.print2d();

        // random array of size 3
        int[] randomArr1 = {(int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10)};

        arr1.appendCol(randomArr1);
        arr1.appendCol(randomArr1);
        arr1.appendCol(randomArr1);
        arr1.appendCol(randomArr1);
        arr1.appendCol(randomArr1);

        arr1.print2d();

        // random array of size 8
        int[] randomArr2 = {(int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10)};

        arr1.appendRow(randomArr2);
        arr1.appendRow(randomArr2);
        arr1.appendRow(randomArr2);
        arr1.appendRow(randomArr2);
        arr1.appendRow(randomArr2);
        arr1.appendRow(randomArr2);

        arr1.print2d();

        TwoDimensionalDynamicArray arr2 = new TwoDimensionalDynamicArray(2, 2);
        arr2.print2d();

        arr2.appendCol(new int[]{3, 6});
        arr2.print2d();

        arr2.appendRow(new int[]{4,2,9});
        arr2.print2d();

    }

}
