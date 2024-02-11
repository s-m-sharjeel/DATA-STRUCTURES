package Labs.Lab14;

public class Driver {

    public static void main(String[] args) {

        System.out.println("Initial Array: ");
        display(new int[]{1, 12, 3, 7, 2, 9, 0});

        System.out.println("Quick Sorting...");
        int[] arr1 = {1, 12, 3, 7, 2, 9, 0};
        Sort.quickSort(arr1, 0, arr1.length - 1);
        display(arr1);

        System.out.println("Merge Sorting...");
        int[] arr2 = {1, 12, 3, 7, 2, 9, 0};
        Sort.mergeSort(arr2, 0, arr2.length - 1);
        display(arr2);

    }

    public static void display(int[] arr) {

        String s = "{";
        for (int i = 0; i < arr.length - 1; i++) {
            s += arr[i] + ", ";
        }
        s += arr[arr.length - 1];

        System.out.println(s += "}");

    }

}
