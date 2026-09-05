import java.util.Arrays;

public class FindMinimum {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Minimum is in the right half
            if (nums[mid] > nums[right]) {

                left = mid + 1;

            }
            // Minimum is at mid or in the left half
            else {

                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        int result = findMin(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Minimum: " + result);
    }
}