package Labs.Lab14;

public class Sort {

    /**
     * quick sorting an array of vertices | O(V*logV)
     * @param arr is the array of vertices
     * @param low is the start index
     * @param high is the last index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1); // sort left sub-array
            quickSort(arr, partitionIndex + 1, high); // sort right sub-array

        }
    }

    /**
     * sorting a partial array with the help of a pivot
     * @param arr is the array of vertices
     * @param low is the start index
     * @param high is the last index
     * @return the new pivot
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choosing the last element as pivot
        int i = (low - 1); // index of smaller element

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j); // swap elements
            }
        }
        swap(arr, i + 1, high); // swap pivot element
        return (i + 1);
    }

    /**
     * swaps two elements in an array
     * @param arr is the array
     * @param i is the first element
     * @param j is the second element
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort(int[] arr, int low, int high) {

        if (low >= high)
            return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);

    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = arr[low + i];

        for (int j = 0; j < n2; ++j)
            rightArray[j] = arr[mid + 1 + j];


        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

    }

}
