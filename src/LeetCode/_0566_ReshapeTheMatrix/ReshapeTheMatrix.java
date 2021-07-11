package LeetCode._0566_ReshapeTheMatrix;

import java.util.Arrays;

/**
 * @author yiqru
 * @date 2021/7/11 10:08 上午
 */
public class ReshapeTheMatrix {

    //遍历赋值
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int a = mat.length;
        int b = mat[0].length;
        if (a * b != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int x = 0, y = 0;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (y >= c) {
                    y = 0;
                    x++;
                }
                res[x][y] = mat[i][j];
                y++;
            }
        }
        return res;
    }

    /**
     * 二位数组转为一维数组
     * (i,j)→i×n+j
     * {i=x/n, j=x%n}
     */
    public static int[][] matrixReshape2(int[][] mat, int r, int c) {
        return null;
    }


    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] res = matrixReshape(nums, 1, 4);
        System.out.println(Arrays.toString(res));
    }
}
