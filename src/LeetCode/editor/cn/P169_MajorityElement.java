package LeetCode.editor.cn;

import java.util.Arrays;

//169.多数元素
public class P169_MajorityElement {
    //leetcode submit region begin(Prohibit modification and deletion)
    //排序法
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new P169_MajorityElement().new Solution();
    }
}
