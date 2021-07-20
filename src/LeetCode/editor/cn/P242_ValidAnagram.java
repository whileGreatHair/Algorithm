package LeetCode.editor.cn;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//
//
// 示例 1:
//
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
//
//输入: s = "rat", t = "car"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= s.length, t.length <= 5 * 104
// s 和 t 仅包含小写字母
//
//
//
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 哈希表 字符串 排序
// 👍 402 👎 0


//242.有效的字母异位词
public class P242_ValidAnagram {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 本地解法和《383.赎金信》题solution2基本一模一样
     */
    class Solution {
        public boolean isAnagram(String s, String t) {
            // 新建小写字母频次统计数组，0-25 分别代表 a-z
            int[] countS = new int[26];
            int[] countT = new int[26];
            // 将 String 转化成 char[] 可以加速程序，因为 String.charAt() 每次调用都会检查下标是否越界
            char[] chars = s.toCharArray();
            char[] chart = t.toCharArray();
            for (char c : chars) {
                countS[c - 'a']++;
            }
            for (char c : chart) {
                countT[c - 'a']++;
            }
            // 对每个字母的出现次数进行比较
            for (int i = 0; i < 26; i++) {
                if (countS[i] != countT[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new P242_ValidAnagram().new Solution();
    }
}
