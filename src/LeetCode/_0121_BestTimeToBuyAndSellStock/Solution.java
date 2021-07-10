package LeetCode._0121_BestTimeToBuyAndSellStock;

/**
 * @author yiqru
 * @date 2021/7/10 6:08 下午
 */
public class Solution {

    //双重遍历
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int p = prices[j] - prices[i];
                if (p > profit) {
                    profit = p;
                }
            }
        }
        return profit;
    }
    //动态规划

    /**
     * 假设在第i天卖出，则第i天的最大利润等于第i天的价格减去[0，i-1]中的最小值。
     */
    public static int maxProfit2(int[] prices) {
        int minPrice = prices[0];//从第一天开始
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];//遍历最小值
            } else if (prices[i] - minPrice > maxProfit) {//遍历最大利润
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println(i);
    }
}
