package LeetCode.editor.cn;
//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
//
//
// 示例 1：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
//
//
// 示例 2：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
//
//
// 示例 3：
//
//
//输入: root = [2,1,3], k = 4
//输出: true
//
//
// 示例 4：
//
//
//输入: root = [2,1,3], k = 1
//输出: false
//
//
// 示例 5：
//
//
//输入: root = [2,1,3], k = 3
//输出: true
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [1, 104].
// -104 <= Node.val <= 104
// root 为二叉搜索树
// -105 <= k <= 105
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树
// 👍 256 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//653.两数之和 IV - 输入 BST
public class P653_TwoSumIvInputIsABst {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    //暴力遍历解法
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            inorder(root);
            if (res.size() < 2) {
                return false;
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = i + 1; j < res.size(); j++) {
                    if (res.get(i) + res.get(j) == k) return true;
                }
            }
            return false;
        }

        List<Integer> res = new ArrayList<>();

        private void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            res.add(root.val);
            inorder(root.right);
            return;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    //优化遍历法（官方）
    class Solution2 {
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet();
            return find(root, k, set);
        }

        public boolean find(TreeNode root, int k, Set<Integer> set) {
            if (root == null)
                return false;
            if (set.contains(k - root.val))
                return true;
            set.add(root.val);
            return find(root.left, k, set) || find(root.right, k, set);
        }
    }

    //遍历加双指针法（BST）
    class Solution3 {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> list = new ArrayList();
            inorder(root, list);
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int sum = list.get(l) + list.get(r);
                if (sum == k)
                    return true;
                if (sum < k)
                    l++;
                else
                    r--;
            }
            return false;
        }

        public void inorder(TreeNode root, List<Integer> list) {
            if (root == null)
                return;
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new P653_TwoSumIvInputIsABst().new Solution();
    }
}
