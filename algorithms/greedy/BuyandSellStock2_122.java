package greedy;

/**
 * @Description
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 仅用于计算最大利润，而不是交易的过程
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 * @Tag 贪心
 * @Date 2021/7/6
 */

public class BuyandSellStock2_122 {
    public static void main(String[] argus) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int dif = prices[i+1] - prices[i];
            if(dif > 0) {
                profit += dif;
            }
        }

        return profit;
    }
}
