package LeetCode._0191_NumberOf1Bits;

/**
 * @author yiqr
 * @create 2021-03-23 16:42
 **/
public class NumberOf1Bits {
    /**
     * 191. 位1的个数
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     * <p>
     * <p>
     * 示例：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
     */

    //官方题解
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOf1Bits number = new NumberOf1Bits();
        int res = number.hammingWeight(6);
        System.out.println(res);
    }
}
