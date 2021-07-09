package LeetCode._0053_MaximumSubarray;

/**
 * @author yiqru
 * @date 2021/7/6 3:07 下午
 */
public class MaxSubArray {
    /**
     * 53.给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * </p>
     */
    public int solution1(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{};
        for (int i = 0; i < nums.length; i++) {
            for (int k = 1; k < nums.length - i; k++) {
                if (nums[i] + nums[k] == target) {
                    return res = new int[]{i, k};
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
