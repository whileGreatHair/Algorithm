package LeetCode.editor.cn;
//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
//
//
// 示例 2：
//
//
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
//
//
// 示例 3：
//
//
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 2 * 105
// -109 <= nums[i] <= 109
//
// Related Topics 栈 数组 二分查找 有序集合 单调栈
// 👍 526 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

//456.132 模式
public class P456_One32Pattern {
    //leetcode submit region begin(Prohibit modification and deletion)
    //单调栈枚举1
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            Deque<Integer> d = new ArrayDeque<>();
            int k = Integer.MIN_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] < k) return true;
                while (!d.isEmpty() && d.peekLast() < nums[i]) {
                    // 事实上，k 的变化也具有单调性，直接使用 k = pollLast() 也是可以的
                    k = Math.max(k, d.pollLast());
                }
                d.addLast(nums[i]);
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    //暴力枚举3
    class Solution2 {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            int numi = nums[0];
            for (int j = 1; j < n; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    if (numi < nums[j] && nums[k] < nums[j]) {
                        return true;
                    }
                    numi = Math.min(numi, nums[j]);
                }
            }
            return false;
        }
    }

    //单调栈枚举3
    class Solution3 {
        public boolean find132pattern(int[] nums) {
            int len = nums.length;
            int[] leftMin = new int[len];
            Arrays.fill(leftMin, Integer.MAX_VALUE);
            for (int i = 1; i < len; i++) {
                leftMin[i] = Math.min(leftMin[i - 1], nums[i - 1]);
            }
            Stack<Integer> stack = new Stack<>();
            for (int j = len - 1; j > -1; j--) {
                int numsK = Integer.MIN_VALUE;
                while (!stack.isEmpty() && stack.peek() < nums[j]) {
                    numsK = stack.pop();
                }
                if (leftMin[j] < numsK) {
                    return true;
                }
                stack.push(nums[j]);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        P456_One32Pattern.Solution solution = new P456_One32Pattern().new Solution();
        int[] nums = {3, 1, 4, 6, 7, 1, 23, 2};
        solution.find132pattern(nums);
    }
}
