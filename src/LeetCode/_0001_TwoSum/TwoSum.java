package LeetCode._0001_TwoSum;

import java.util.HashMap;

/**
 * @author yiqru
 * @date 2021/7/6 3:36 下午
 */
public class TwoSum {
    /**
     * <p>1.给定一个整数数组 nums 和一个整数目标值 target ，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。</p>
     *
     * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。</p>
     * <p>
     * 你可以按任意顺序返回答案。
     *
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * </p>
     */

    //暴力枚举法
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //哈希表法
    public int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target -nums[i]), i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }
}
