public class Max {
    public static void main(String[] args) {
        int[] nums = {6, 3, -10, 2, 5, 9};
        System.out.println(max(nums));
    }

    /**
     * Finds and returns the biggest number in an array of integers
     * @param nums an array of integers
     * @return the biggest number in this arroy of integers
     * @throws IllegalArgumentException when nums is an empty array
     */
    public static int max(int[] nums) throws IllegalArgumentException {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Cannot find max for an empty array!");
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }
}
