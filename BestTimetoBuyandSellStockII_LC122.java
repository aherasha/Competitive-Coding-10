/*
Iterate through the price array and add every positive difference between consecutive days to the total profit.
This simulates buying before each price rise and selling at the peak, achieving maximum profit with unlimited transactions.

Space Complexity - O(1)
Time Complexity - O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
 */

public class BestTimetoBuyandSellStockII_LC122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0;i < prices.length-1; i++) { // 7 1 5 3 6 4
            if(prices[i] < prices[i+1]) {
                profit += prices[i+1] - prices[i];  //4
            }
        }
        return profit;
    }
}