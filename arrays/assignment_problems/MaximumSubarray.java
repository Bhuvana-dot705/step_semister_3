import java.util.Arrays;

public class MaximumSubarray {


    public static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Either start a new subarray
            // or extend the existing subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.print("Input: " + Arrays.toString(nums));
        System.out.print("   ");
        System.out.print("Maximum Subarray Sum: " + result);
    }
}