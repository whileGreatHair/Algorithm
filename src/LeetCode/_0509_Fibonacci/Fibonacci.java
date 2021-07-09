package LeetCode._0509_Fibonacci;

import java.util.Arrays;

/**
 * @author yiqru
 * @date 2021/7/5 3:09 下午
 */
public class Fibonacci {
    /**
     * <p>
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * <p>
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n) 。
     * <p>
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     */

    //暴力解法
    public static int fib1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //备忘录解法
    public static int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        Integer[] memo = new Integer[n + 1];
        return helper(memo, n);
    }

    private static int helper(Integer[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }


    //DP数组的迭代解法
    public static int fib3(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        Integer[] dp = new Integer[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //状态压缩后的迭代解法
    public static int fib4(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    public static void main(String[] args) {
        int i = fib3(20);
        System.out.println(i);
    }
}
