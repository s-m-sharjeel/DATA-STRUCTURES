package Assignments.Assignment1.question2;

class MyArrayList<T extends Comparable<T>>{
    private T[] arr;
    private int currIndex;

    MyArrayList() { // default constructor to create an array
        arr = (T[])(new Comparable[10]);
        currIndex = -1;
    }

    MyArrayList(int size) { // constructor to create an array
        arr = (T[])(new Comparable[size]);
        currIndex = -1;
    }

    /**
     * prints the array
     */
    public void print() {

        System.out.print("[ ");
        for (int i = 0; i <= currIndex; i++) {
            System.out.print(arr[i]);
            if (i == currIndex)
                System.out.print(" ");
            else
                System.out.print(", ");
        }
        System.out.println("]");
    }

    /**
     * adds a value at the starting index of the array by shifting all the others (if any) one place to the right
     * @param value is the data to be added
     */
    public void addAtFront(T value) {

        if (currIndex == arr.length - 1)
            doubleSizeOfArray();

        for (int i = currIndex; i >= 0 ; i--) {
            arr[i + 1] = arr[i];
        }

        arr[0] = value;
        currIndex++;

    }

    /**
     * adds a value at the last index of the array
     * @param value is the data to be added
     */
    public void addAtEnd(T value) {

        if (currIndex == arr.length - 1)
            doubleSizeOfArray();

        currIndex++;
        arr[currIndex] = value;

    }

    /**
     * compares and inserts a value in the array in some order
     * @param value is the data being inserted
     */
    public void InsertInOrder(T value) {

        // if array is full, double the size of array
        if (currIndex == arr.length - 1)
            doubleSizeOfArray();

        // if array is empty, simply add data to the first index (no need for sorting)
        if (currIndex == -1) {
            arr[0] = value;

        } else {

            // sorting algorithm:

            for (int i = currIndex; i >= 0; i--) {

                if (arr[i].compareTo(value) < 0) {
                    // place data at the next index of the data which is smaller than the data being inserted
                    arr[i + 1] = value;
                    break;
                }

                // move data one index forward if it is greater than the data being inserted
                arr[i + 1] = arr[i];

                // no data is found smaller than the new data being inserted
                if (i == 0)
                    // so it is placed at the first index
                    arr[0] = value;

            }

        }

        // increment current index as new data is added to the array
        currIndex++;

    }

    /**
     * searches for the value
     * @param value is the data to be searched for
     * @return the index of the first occurrence of the value or -1 if not found
     */
    public int find(T value) {

        for (int i = 0; i <= currIndex; i++) {

            if (arr[i].equals(value)) {
                return i;
            }

        }

        return -1;  // element not found (-1 is used as sentinel value)

    }

    /**
     * reverses the array
     * for e.g. [1, 2, 3] -> [3, 2, 1]
     */
    public void reverse(){

        for (int i = 0; i < currIndex/2; i++) {

            T temp = arr[i];
            arr[i] = arr[currIndex - i];
            arr[currIndex - i] = temp;

        }

    }

    /**
     * removes the first occurrence of the  given value
     * @param value is the data to be removed
     */
    public void removeFirst(T value) {

        int index = find(value);
        if (index == -1)
            return;

        for (int i = index; i < currIndex; i++) {
            arr[i] = arr[i + 1];
        }

        currIndex--;

    }

    /**
     * removes all occurrences of the  given value
     * @param value is the data to be removed
     */
    public void removeAll(T value) {

        while (find(value) != -1)   // value exists in the array
            removeFirst(value);

    }

    /**
     * returns the capacity of the array
     * @return the occupied cells in the array
     */
    public int length(){

        return currIndex + 1;

    }

    /**
     * @return true if array is empty and false otherwise
     */
    public boolean isEmpty(){

        return currIndex == -1;

    }

    /**
     * doubles the size of array
     */
    private void doubleSizeOfArray(){
        T[] newArr = (T[])(new Comparable[arr.length * 2]);
        for (int i = 0; i <= currIndex; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

}

