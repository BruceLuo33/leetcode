//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.29 第一遍
 - 思路：动态规划。与 121、122 等题不同的是，这里的 k 不能忽略了。但是也不难，加上一个对 k 的循环即可。
 - Recursive Cases：
 1. dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
 2. dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
 3. dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
 4. dp[i][1][1] = max(dp[i-1][1][1], - prices[i])
 复杂度分析：O（N），空间复杂度：O（1）
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, m = 2;
        int dp_i_2_0 = 0, dp_i_1_0 = 0;
        int dp_i_2_1 = Integer.MIN_VALUE, dp_i_1_1 = Integer.MIN_VALUE;
        for ( int i = 0; i < n; i++) {
            for (int k = m; k > 0; k--) {
                dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
                dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
                dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
                dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
            }
        }
        return dp_i_2_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
