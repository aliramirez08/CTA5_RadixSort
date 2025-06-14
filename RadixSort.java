import java.util.Arrays;

public class RadixSort {

    // Utility function to get the maximum value in the array
    private static int getMax(Integer[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // A stable counting sort that sorts the array based on the digit represented by exp
    private static void countingSort(Integer[] arr, int exp) {
        int n = arr.length;
        Integer[] output = new Integer[n]; // Output array
        int[] count = new int[10]; // Base 10 digits (0-9)

        // Step 1: Count occurrences of digits
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Step 2: Change count[i] so that count[i] contains actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build the output array (stable sort - traverse backwards)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Step 4: Copy the output array to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Main Radix Sort function
    public static void radixSort(Integer[] arr) {
        // Step 1: Find the maximum number to know number of digits
        int max = getMax(arr);
        int pass = 1;

        // Step 2: Perform counting sort for every digit (exp = 1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);

            // Print array after each digit pass to show progress
            System.out.print("After pass " + pass + " (exp = " + exp + "): ");
            System.out.println(Arrays.toString(arr));
            pass++;
        }
    }
}
