package LeetCode._0118_PascalsTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yiqru
 * @date 2021/7/11 4:28 下午
 */
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        //一层层计算{
        for (int i = 0; i < numRows; ++i) {
            //新建一行
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);

        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> re = generate(5);
    }

}
