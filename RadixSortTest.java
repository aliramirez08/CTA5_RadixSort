import java.util.Arrays;

public class RadixSortTest {
    public static void main(String[] args) {
        // Sample array of Integer objects
        Integer[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        // Print original array
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // Call radix sort
        RadixSort.radixSort(arr);

        // Print sorted array
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}
