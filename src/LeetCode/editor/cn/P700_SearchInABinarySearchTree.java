package LeetCode.editor.cn;
//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//
// 例如，
//
//
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
//
//
// 你应该返回如下子树:
//
//
//      2
//     / \
//    1   3
//
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
// Related Topics 树 二叉搜索树 二叉树
// 👍 140 👎 0


//700.二叉搜索树中的搜索
public class P700_SearchInABinarySearchTree {
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
    //递归法
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val) return root;
            TreeNode left = searchBST(root.left, val);
            if (left == null) {
                TreeNode right = searchBST(root.right, val);
                return right;
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //LeetCode 递归法
    class Solution2 {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || val == root.val) return root;
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }

    //迭代法
    class Solution3 {
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && val != root.val)
                root = val < root.val ? root.left : root.right;
            return root;
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
        Solution solution = new P700_SearchInABinarySearchTree().new Solution();
    }
}
