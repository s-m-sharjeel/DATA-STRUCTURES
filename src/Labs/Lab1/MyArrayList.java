package Labs.Lab1;
class MyArrayList {
    private int[] arr;
    private int currIndex;

    MyArrayList() { // default constructor to create an array
        arr = new int[10];
        currIndex = -1;
    }

    MyArrayList(int size) { // constructor to create an array
        arr = new int[size];
        currIndex = -1;
    }

    public void PrintList() {

        System.out.print("[ ");
        for (int i = 0; i <= currIndex; i++)
            System.out.print(arr[i] + " ");
        System.out.println("]");
    }

    public void InsertInOrder(int v) {

        if (currIndex == arr.length - 1) {
            int[] newArr = new int[arr.length * 2];
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
                if (arr[index] > v)
                    break;
            }
            for (int i = currIndex; i >= index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = v;
            currIndex++;
        }
    }

    public int Length() {

        return currIndex + 1;

    }

    public int get(int index) {

        if (index <= currIndex)
            return arr[index];

        System.out.println("Index out of bounds");
        return -1;

    }

    public void Update(int index, int value) {

        arr[index] = value;

    }

    public int Find(int value) {

        for (int i = 0; i <= currIndex; i++) {

            if (arr[i] == value) {
                return i;
            }

        }

        System.out.println("not found");
        return -1;

    }

    public void Remove(int value) {

        int index = Find(value);
        if (index == -1)
            return;

        for (int i = index; i < currIndex; i++) {
            arr[i] = arr[i + 1];
        }

        currIndex--;

    }

}

