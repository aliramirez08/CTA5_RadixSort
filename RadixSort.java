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
        int[] count = new int[10];         // Base 10 digits (0-9)

        // Step 1: Count digit occurrences
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Step 2: Transform count[i] to actual positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build the output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Step 4: Copy output to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Main radix sort function with pause after each pass
    public static void radixSort(Integer[] arr) {
        int max = getMax(arr); // Find max to know number of digits
        int pass = 1;

        // Sort for every digit (exp = 1, 10, 100...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);

            // Print array state after current pass
            System.out.print("After pass " + pass + " (exp = " + exp + "): ");
            System.out.println(Arrays.toString(arr));

            // Prompt user to press Enter before continuing
            System.out.println("Press Enter to continue...");
            try {
                System.in.read(); // Waits for Enter key
            } catch (Exception e) {
                // Fails silently if input fails
            }

            pass++;
        }
    }
}
