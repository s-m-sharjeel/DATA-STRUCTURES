package Assignments.Assignment3.question2;

class ArrayList<T extends Comparable<T>>{
    private T[] arr;
    private int currIndex;

    ArrayList() { // default constructor to create an array
        arr = (T[])(new Comparable[10]);
        currIndex = -1;
    }

    /**
     * inserts an element at the end of the array
     */
    public void insert(T data) {

        if (currIndex == arr.length - 1) {
            duplicateArrSize();
        }

        currIndex++;
        arr[currIndex] = data;

    }

    /**
     * duplicates the array with double size
     */
    private void duplicateArrSize() {

        T[] newArr = (T[])(new Comparable[arr.length * 2]);
        if (currIndex + 1 >= 0) System.arraycopy(arr, 0, newArr, 0, currIndex + 1);
        arr = newArr;
    }

    /**
     * clears all the elements
     */
    public void clear(){

        for (int i = 0; i <= currIndex; i++) {
            arr[i] = null;
        }

        currIndex = -1;

    }

    /**
     * returns the length of the array
     * @return length
     */
    public int Length() {

        return currIndex + 1;

    }

    /**
     * returns the value at the given index
     * @param index is the index
     * @return the value at the index
     */
    public T get(int index) {

        if (index <= currIndex)
            return arr[index];

        System.out.println("Index out of bounds");
        return null;

    }

    /**
     * searches for the value
     * @param value is the value to be searched for
     * @return index of the value
     */
    public int find(T value) {

        for (int i = 0; i <= currIndex; i++) {

            if (arr[i].compareTo(value) == 0) {
                return i;
            }

        }

        System.out.println("not found");
        return -1;

    }

    /**
     * removes the given value
     * @param value is the data to be removed
     */
    public void Remove(T value) {

        int index = find(value);
        if (index == -1)
            return;

        for (int i = index; i < currIndex; i++) {
            arr[i] = arr[i + 1];
        }

        currIndex--;

    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        for (T t : arr) {
            s.append(t).append("\n");
        }
        return s.toString();

    }

    /**
     * @return the size of the array
     */
    public int size(){

        return arr.length;

    }

    /**
     * @return the occupied cells in the array
     */
    public int length() {

        return currIndex + 1;

    }

    /**
     * @return true if array is empty and false otherwise
     */
    public boolean isEmpty(){

        return currIndex == -1;

    }

}

