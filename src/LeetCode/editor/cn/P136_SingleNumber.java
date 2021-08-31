package LeetCode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//136.只出现一次的数字
public class P136_SingleNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    //位运算
    class Solution {
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new P136_SingleNumber().new Solution();
    }
}
