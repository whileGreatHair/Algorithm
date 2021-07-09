package LeetCode._0217_ContainsDuplicate;

import java.util.Arrays;

/**
 * @author yiqru
 * @date 2021/7/5 4:18 下午
 */
public class containsDuplicate {
    /**
     * <p>
     * 217.给定一个整数数组，判断是否存在重复元素。
     *
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * </p>
     *
     *
     * <p>
     * 输入: [1,2,3,1]
     * 输出: true
     * </p>
     */

    public boolean solution1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
