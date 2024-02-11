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
    public void PrintList() {

        System.out.print("[ ");
        for (int i = 0; i <= currIndex; i++)
            System.out.print(arr[i] + " ");
        System.out.println("]");
    }

    /**
     * compares and inserts a value in the array in some order
     * @param v
     */
    public void InsertInOrder(T v) {

        if (currIndex == arr.length - 1) {
            T[] newArr = (T[])(new Comparable[arr.length * 2]);
            for (int i = 0; i <= currIndex; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        if (currIndex == -1) {
            currIndex++;
            arr[currIndex] = v;
        } else {
            int index;
            for (index = 0; index <= currIndex; index++) {
                if (arr[index].compareTo(v) > 0)
                    break;
            }
            for (int i = currIndex; i >= index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = v;
            currIndex++;
        }
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
     * @return
     */
    public int Length() {

        return currIndex + 1;

    }

    /**
     * returns the value at the given index
     * @param index
     * @return
     */
    public T get(int index) {

        if (index <= currIndex)
            return arr[index];

        System.out.println("Index out of bounds");
        return null;

    }

    /**
     * updates the value at the specified index
     * @param index
     * @param value
     */
    public void Update(int index, T value) {

        arr[index] = value;

    }

    /**
     * searches for the value
     * @param value
     * @return
     */
    public int Find(T value) {

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
     * @param value
     */
    public void Remove(T value) {

        int index = Find(value);
        if (index == -1)
            return;

        for (int i = index; i < currIndex; i++) {
            arr[i] = arr[i + 1];
        }

        currIndex--;

    }

    @Override
    public String toString() {

        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + "\n";
        }
        return s;

    }

    /**
     * inserts an element at the end of the array
     * @param data
     */
    public void add(T data){

        if (currIndex == arr.length - 1) {
            T[] newArr = (T[])(new Comparable[arr.length * 2]);
            for (int i = 0; i <= currIndex; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        currIndex++;
        arr[currIndex] = data;

    }

    /**
     * compares and returns the max value
     * @return
     */
    public T findMax(){

        T max = arr[0];
        for (int i = 1; i <= currIndex; i++) {
            if (max.compareTo(arr[i]) < 0){
                max = arr[i];
            }
        }

        return max;

    }

    /**
     * returns the capacity of the array
     * @return
     */
    public int size(){

        return arr.length;

    }

    /**
     * returns the array
     * @return
     */
    public T[] toArray(){

        return arr;

    }

    /**
     * returns true if array is empty and false otherwise
     * @return
     */
    public boolean isEmpty(){

        if (currIndex == -1)
            return true;

        return false;

    }

}

