package LeetCode.editor.cn;
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。
//
// 叶子节点 是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,3], targetSum = 5
//输出：false
//
//
// 示例 3：
//
//
//输入：root = [1,2], targetSum = 0
//输出：false
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [0, 5000] 内
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
// Related Topics 树 深度优先搜索 二叉树
// 👍 623 👎 0


import java.util.*;

//112.路径总和
public class P112_PathSum {
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
    /**
     * 精简版递归法
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return targetSum == root.val;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

        }
    }

    /**
     * 详细版递归法
     */
    class Solution2 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            targetSum -= root.val;
            // 叶子结点
            if (root.left == null && root.right == null) {
                return targetSum == 0;
            }
            if (root.left != null) {
                boolean left = hasPathSum(root.left, targetSum);
                if (left) {// 已经找到
                    return true;
                }
            }
            if (root.right != null) {
                boolean right = hasPathSum(root.right, targetSum);
                if (right) {// 已经找到
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 迭代法
     */
    class Solution3 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            Stack<TreeNode> currNode = new Stack<>();
            Stack<Integer> sum = new Stack<>();
            currNode.push(root);
            sum.push(root.val);
            while (!currNode.isEmpty()) {
                int size = currNode.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = currNode.pop();
                    int currSum = sum.pop();
                    // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                    if (node.left == null && node.right == null && currSum == targetSum){
                        return true;
                    }
                    // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                    if (node.right != null) {
                        currNode.push(node.right);
                        sum.push(currSum + node.right.val);
                    }
                    // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                    if (node.left != null) {
                        currNode.push(node.left);
                        sum.push(currSum + node.left.val);
                    }
                }
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
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
        Solution solution = new P112_PathSum().new Solution();
    }
}
