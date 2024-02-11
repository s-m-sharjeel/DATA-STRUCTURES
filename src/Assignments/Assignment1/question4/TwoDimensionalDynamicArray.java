package Assignments.Assignment1.question4;

public class TwoDimensionalDynamicArray {

    int[][] arr;
    int currRowInd;
    int currColInd;

    public TwoDimensionalDynamicArray(int rows, int columns) {

        arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = (int)(10 * Math.random());  // random number between 0 and 10
            }
        }

        currRowInd = rows - 1;
        currColInd = columns - 1;

    }

    /**
     * appends another row to the array if its size == number of occupied columns, throws an exception otherwise
     * @param rowArray is the row array to be appended
     */
    public void appendRow(int[] rowArray) {

        if (rowArray.length != currColInd + 1)
            throw new RuntimeException("Invalid row array size");

        if (currRowInd + 1 == arr.length)
            doubleRowOfArray();

        currRowInd++;

        for (int i = 0; i <= currColInd; i++) {
            arr[currRowInd][i] = rowArray[i];
        }

    }

    /**
     * appends another column to the array if its size == number of occupied rows, throws an exception otherwise
     * @param colArray is the column array to be appended
     */
    public void appendCol(int[] colArray) {

        if (colArray.length != currRowInd + 1)
            throw new RuntimeException("Invalid column array size");

        if (currColInd + 1 == arr[0].length)
            doubleColOfArray();

        currColInd++;

        for (int i = 0; i <= currRowInd; i++) {
            arr[i][currColInd] = colArray[i];
        }
    }

    /**
     * doubles the number of rows of the array
     */
    private void doubleRowOfArray(){

        int[][] newArr = new int[(currRowInd + 1) * 2][currColInd + 1];
        for (int i = 0; i <= currRowInd; i++) {
            for (int j = 0; j <= currColInd; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        arr = newArr;

    }

    /**
     * doubles the number of columns of the array
     */
    private void doubleColOfArray(){

        int[][] newArr = new int[currRowInd + 1][(currColInd + 1) * 2];
        for (int i = 0; i <= currRowInd; i++) {
            for (int j = 0; j <= currColInd; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        arr = newArr;

    }

    /**
     * prints the 2d array
     */
    public void print2d(){

        System.out.println("array: ");
        for (int i = 0; i <= currRowInd; i++) {
            for (int j = 0; j <= currColInd; j++) {
                System.out.print(arr[i][j]);
                if (j != currColInd)
                    System.out.print(",");
            }
            System.out.println();
        }

    }

}
