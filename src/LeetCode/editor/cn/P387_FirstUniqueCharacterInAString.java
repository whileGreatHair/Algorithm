package LeetCode.editor.cn;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 队列 哈希表 字符串 计数
// 👍 414 👎 0


import java.util.HashMap;

//387.字符串中的第一个唯一字符
public class P387_FirstUniqueCharacterInAString {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 使用哈希表存储频数，两次遍历
     */
    class Solution {
        public int firstUniqChar(String s) {
            char[] c = s.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < c.length; i++) {
                char ch = c[i];
                if (map.get(ch) != null) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = c[i];
                if (map.get(ch) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 优化时间、空间复杂度
     * 使用长度为26的数组，两次遍历
     */
    class Solution2 {
        public int firstUniqChar(String s) {
            int[] arr = new int[26];
            int n = s.length();
            for (int i = 0; i < n; i++) {
                arr[s.charAt(i)-'a']++ ;
            }
            for (int i = 0; i < n; i++) {
                if (arr[s.charAt(i)-'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        Solution solution = new P387_FirstUniqueCharacterInAString().new Solution();
        int leetcode = solution.firstUniqChar("loveleetcode");
    }
}
