package LeetCode.editor.cn;
//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 你可以假设两个字符串均只含有小写字母。
//
// Related Topics 哈希表 字符串 计数
// 👍 160 👎 0


import java.util.HashMap;

//383.赎金信
public class RansomNote {
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 本质上就是magazine里字母要包含ransomNote里的字母
     * 先遍历magazine,讲字母和频数放入哈希表
     * 然后遍历ransomNote，从哈希表取，如果频数不够说明无法包含，返回false
     */
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            //统计字母出现的频数
            HashMap<Character, Integer> map = new HashMap<>();
            char[] r = ransomNote.toCharArray();
            char[] m = magazine.toCharArray();
            //先遍历一遍杂志
            for (int i = 0; i < magazine.length(); i++) {
                char ch = m[i];
                int count = map.getOrDefault(ch, 0) + 1;
                map.put(ch, count);
            }
            //再遍历赎金信
            for (int i = 0; i < ransomNote.length(); i++) {
                char ch = r[i];
                int count = map.getOrDefault(ch, 0);
                if (count > 0) {
                    count--;
                    if (count > 0) {
                        map.put(ch, count);

                    } else {
                        map.remove(ch);
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 使用两个26位数组来分别存储26个字母在magazine和ransomNote
     * 然后比较是否magazine对应字母频数大于ransomNote
     */
    class Solution2 {
        public boolean canConstruct(String ransomNote, String magazine) {
            // 新建小写字母频次统计数组，0-25 分别代表 a-z
            int[] charCountRN = new int[26];
            int[] charCountM = new int[26];
            // 将 String 转化成 char[] 可以加速程序，因为 String.charAt() 每次调用都会检查下标是否越界
            char[] charArrayRN = ransomNote.toCharArray();
            char[] charArrayM = magazine.toCharArray();
            // 统计救赎信的各个字母出现次数
            for (char c : charArrayRN) {
                charCountRN[c-'a']++;
            }
            // 统计杂志的各个字母出现次数
            for (char c : charArrayM) {
                charCountM[c-'a']++;
            }
            // 对每个字母的出现次数进行比较
            for (int i = 0; i < 26; i++) {
                if(charCountRN[i] > charCountM[i]){
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        boolean b = solution.canConstruct("aa", "ab");
    }
}

