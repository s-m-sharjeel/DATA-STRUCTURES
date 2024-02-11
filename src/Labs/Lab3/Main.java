package Labs.Lab3;

public class Main {

    public static void main(String[] args) {

        System.out.println("problem 1: ");

        int n = 1000;

        int[] arr = new int[n];

        // adds values 0 to n-1
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        System.out.println(linearSearch(999, arr));
        System.out.println(binarySearch(999, arr));

        System.out.println("problem 2:");

        boolean flag = false;   // to find the minimum value for which the percentage of dominant term is 99.5%

        for (int i = 10; i <= 1000; i+=10) {    // taking values 10, 20, 30, ... 1000

            // creating new array of size i
            int[] array = new int[i];

            for (int j = 0; j < i; j++)
                array[j] = j;

            if (myfunc(array, i - 1) >= 99.5 && !flag) {
                System.out.println("At values above " + i + ", the dominant term accounts for more than 99.5% of the counts");
                // 35 is the least value of n for which the percentage of dominant term is 99.5% (when incremented one-by-one)
                flag = true;
            }
        }

    }

    /**
     * linearly traverses through the array to search for a specific element
     * @param num if the number to be searched
     * @param arr is the array where it is to be searched for
     * @return the index of the element where it is found (-1 if not found)
     */
    public static int linearSearch(int num, int[] arr){

        long start = System.nanoTime();

        int count = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == num) {
                index = i;
                break;
            }
        }

        long end = System.nanoTime();

        System.out.println("total no. of operations: " + count);
        System.out.println("total time taken: " + (end - start));

        return index;

    }

    /**
     * binary searches the array to search for a specific element
     * @param num if the number to be searched
     * @param arr is the array where it is to be searched for
     * @return the index of the element where it is found (-1 if not found)
     */
    public static int binarySearch(int num, int[] arr){

        long start = System.nanoTime();
        int count = 0;

        int index = -1;
        int first = 0;
        int last = arr.length - 1;
        int mid = (last - first) / 2;
        boolean flag = false;

        while (first < last) {
            count++;
            if (arr[mid] > num)
                last = mid - 1;
            else if(arr[mid] == num) {
                index = mid;
                flag = true;
                break;
            } else
                first = mid + 1;
            mid = (first + last) / 2;
        }

        if (!flag && arr[mid] == num) {
            count++;
            index = mid;
        }

        long end = System.nanoTime();

//        System.out.println("total no. of operations: " + count);
//        System.out.println("expected no. of operations: " + (Math.log(arr.length) / (Math.log(2))));
//        System.out.println("total time taken: " + (end - start));

        return index;

    }

    /**
     * prints the count for operations and the dominant term
     * @param arr to perform binary search
     * @param num to search for
     * @return the percentage of dominant term count in the total count
     */
    public static float myfunc(int[] arr, int num){

        // problem size
        int n = arr.length;

        int count = 0;
        int countForDominantTerm = 0;

        for (int i = 0; i < n; i++) {
            count++;    // N
            binarySearch(num, arr);
            count += Math.round(Math.log(n) / Math.log(2)); // log(N)
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    count++;    // N^3
                    countForDominantTerm++; // N^3
                }
            }
        }

        float percent = ((float) countForDominantTerm / count) * 100;

        System.out.println("size of problem: " + n);
        System.out.println("count: " + count);
        System.out.println("count for dominant term: " + countForDominantTerm);
        System.out.println("percentage: " + percent);

        return percent;

    }

}
