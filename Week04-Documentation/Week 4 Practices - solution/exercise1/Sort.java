import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 4, 54, 2, 3, 1, -5, 2, -4, 37};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums) {
        // (1) E. Start from the second element and iterate through the array
        for (int i = 1; i < nums.length; i++) {
            insert(nums, i);
        }
    }

    // (2) J. Helper method to insert the element at index i into its correct position
    private static void insert(int[] nums, int i) {
        // (3) B. Compare the target element with each element before it
        for (int j = 0; j < i; j++) {
            // (4) D. If an element greater than the target is found
            if (nums[j] > nums[i]) {
                // (5) I. Temporarily store the target element
                int n = nums[i];
                // (6) F. Shift all elements between the found position and the target's position to the right
                move(nums, j, i);
                // (7) C. Insert the target element at the found position
                nums[j] = n;
            }
        }
    }

    // (8) A. Shifts elements to the right to make space for the target element's insertion
    private static void move(int[] nums, int begin, int end) {
        assert begin < end; // (9) K. Ensure that the beginning pointer is on the left of the end pointer
        // (10) G. Start from the target element's original position and go from right to left
        for (int k = end; k > begin; k--) {
            // (11) H. Move each element one position to the right
            nums[k] = nums[k - 1];
        }
    }
}
