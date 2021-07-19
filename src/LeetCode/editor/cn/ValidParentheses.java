package LeetCode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2506 👎 0


import java.util.*;

//20.有效的括号
public class ValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 官方题解
     * 利用栈先进后出的特性
     * 遇到某类型右括号时，栈顶一定为对应的左括号
     * 如果不是同类型或者不存在，则返回false
     */
    class Solution {
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<Character>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 该方法的巧妙之处在于，遍历时遇到左括号时，把对应的右括号存入栈
     * 等遍历到右括号时，将栈顶的右括号和当前的右括号进行对比，不一样则返回false
     */
    class Solution2 {
        public boolean isValid(String s) {
            if (s.isEmpty())
                return true;
            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(')
                    stack.push(')');
                else if (c == '{')
                    stack.push('}');
                else if (c == '[')
                    stack.push(']');
                else if (stack.empty() || c != stack.pop())
                    return false;
            }
            return stack.empty();
        }
    }


    public static void main(String[] args) {
        Solution2 solution = new ValidParentheses().new Solution2();
        solution.isValid("()[]{}");
    }
}
