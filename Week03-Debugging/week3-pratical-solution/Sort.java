import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 4, 54, 2, 3, 25, -5, -8, -4, 37};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            insert(nums, i);
        }
    }

    static void insert(int[] nums, int i) {
        for (int j = 0; j < i; j++) {
            if (nums[j] > nums[i]) {
                int n = nums[i];
                move(nums, j, i);
                nums[j] = n;
            }
        }
    }

    static void move(int[] nums, int begin, int end) {
        for (int i = end; i > begin; i--) {
            nums[i] = nums[i - 1];
        }
    }
}
