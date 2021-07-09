package LeetCode._0456_Pattern123;

/**
 * @author yiqr
 * @create 2021-03-24 16:54
 **/
public class Pattern132 {

    /**
     * 456.给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
     * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
     * <p>
     * <p>
     * 示例
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 解释：序列中不存在 132 模式的子序列。
     * <p>
     * 输入：nums = [-1,3,2,0]
     * 输出：true
     * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
     */

    public boolean solution1(int[] nums) {
        return true;
    }

    public static void main(String[] args) {
        Pattern132 pattern132 = new Pattern132();
        int[] nums = {-1, 3, 2, 0};
        boolean b = pattern132.solution1(nums);
        System.out.println(b);
    }
}
