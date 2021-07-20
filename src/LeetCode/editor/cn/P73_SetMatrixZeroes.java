package LeetCode.editor.cn;
//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
// 进阶：
//
//
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
// 你能想出一个仅使用常量空间的解决方案吗？
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
//
//
// 示例 2：
//
//
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
//
// Related Topics 数组 哈希表 矩阵
// 👍 512 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

//73.矩阵置零
public class P73_SetMatrixZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用标记。我使用Set来标记，可优化为 Boolean 数组
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;//行
            int n = matrix[0].length;//列
            HashSet<Integer> r = new HashSet<>();//存在0的行
            HashSet<Integer> c = new HashSet<>();//存在0的列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        r.add(i);
                        c.add(j);
                    }
                }
            }
            //置零
            for (int i = 0; i < m; i++) {
                if (r.contains(i)) {
                    matrix[i] = new int[n];
                }
                Iterator<Integer> iterator = c.iterator();
                while (iterator.hasNext()) {
                    matrix[i][iterator.next()] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 将Solution中的Set集合优化为Boolean数组
     * 时间复杂度：O(mn),空间复杂度O(m+n)
     */
    class Solution2 {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;//行
            int n = matrix[0].length;//列
            boolean[] row = new boolean[m];
            boolean[] col = new boolean[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = col[j] = true;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * O(1)空间解法
     * 1.使用两个变量r0和c0，记录「首行」和「首列」是否该被置零
     * 2.其他非首行首列的位置的置零信息存储到矩阵的首行、首列中
     * 3.根据置零信息，置零「非首行首列」的
     */
    class Solution3 {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;//行
            int n = matrix[0].length;//列
            boolean r0 = false, c0 = false;
            for (int i = 0; i < m; i++) {
                if (matrix[0][i] == 0) {
                    r0 = true;
                }
                break;
            }
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] == 0) {
                    c0 = true;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }

            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    Arrays.fill(matrix[i], 0);
                }
            }

            // 3. 根据最开始记录的「首行」和「首列」信息，进行「首行首列」置零
            if (r0) for (int i = 0; i < m; i++) matrix[i][0] = 0;
            if (c0) Arrays.fill(matrix[0], 0);
        }

    }

    public static void main(String[] args) {
        Solution solution = new P73_SetMatrixZeroes().new Solution();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix);
    }
}
