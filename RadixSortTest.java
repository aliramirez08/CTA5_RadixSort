import java.util.Arrays;

public class RadixSortTest {
    public static void main(String[] args) {
        Integer[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // Call radix sort with pauses
        RadixSort.radixSort(arr);

        System.out.println("Final Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}
