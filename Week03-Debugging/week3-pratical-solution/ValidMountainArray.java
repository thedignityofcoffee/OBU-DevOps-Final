import java.util.Arrays;
import java.util.HashMap;

public class ValidMountainArray {
    public static void main(String[] args) {
        // test 1
        int[] nums1 = {};
        assert isValidMountainArray(nums1) == false;
        // test 2
        int[] nums2 = {1};
        assert isValidMountainArray(nums2) == false;
        // test 3
        int[] nums3 = {1, 2};
        assert isValidMountainArray(nums3) == false;
        // test 4
        int[] nums4 = {2, 2};
        assert isValidMountainArray(nums4) == false;
        // test 5
        int[] nums5 = {2, 1};
        assert isValidMountainArray(nums5) == false;
        // test 6
        int[] nums6 = {1, 2, 3, 4, 5};
        assert isValidMountainArray(nums6) == false;
        // test 7
        int[] nums7 = {5, 4, 3, 2, 1};
        assert isValidMountainArray(nums7) == false;
        // test 8
        int[] nums8 = {3, 2, 1, 2, 3};
        assert isValidMountainArray(nums8) == false;
        // test 9
        int[] nums9 = {1, 2, 2, 3, 4, 3};
        assert isValidMountainArray(nums9) == false;
        // test 10
        int[] nums10 = {1, 2, 2, 1};
        assert isValidMountainArray(nums10) == false;
        // test 11
        int[] nums11 = {1, 3, 2, 2, 1};
        assert isValidMountainArray(nums11) == false;
        // test 12
        int[] nums12 = {2, 2, 2};
        assert isValidMountainArray(nums12) == false;
        // test 13
        int[] nums13 = {1, 2, 2};
        assert isValidMountainArray(nums13) == false;
        // test 14
        int[] nums14 = {2, 2, 3};
        assert isValidMountainArray(nums14) == false;
        // test 15
        int[] nums15 = {2, 1, 1};
        assert isValidMountainArray(nums15) == false;
        // test 16
        int[] nums16 = {1, 2, 3, 2, 4};
        assert isValidMountainArray(nums16) == false;
        // test 17
        int[] nums17 = {3, 1, 2, 1};
        assert isValidMountainArray(nums17) == false;
        // test 18
        int[] nums18 = {1, 2, 1};
        assert isValidMountainArray(nums18) == true;
        // test 19
        int[] nums19 = {1, 3, 2, 1};
        assert isValidMountainArray(nums19) == true;
        // test 20
        int[] nums20 = {1, 2, 3, 1};
        assert isValidMountainArray(nums20) == true;
    }
    static boolean isValidMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int i = 1;
        boolean ascending = true;
        while (ascending && i < arr.length) {
            ascending = arr[i] > arr[i - 1];
            if (ascending) i++;
        }
        if (i == arr.length) return false;
        if (i == 1) return false;
        boolean descending = true;
        while (descending && i < arr.length) {
            descending = arr[i] < arr[i - 1];
            if (descending) i++;
        }
        return i == arr.length;
    }
}

