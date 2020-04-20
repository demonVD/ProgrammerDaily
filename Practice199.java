  // Best Time to Buy and Sell Stock II
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int buy = prices[0];
        int sell = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < sell){
                profit += (sell - buy);
                buy = prices[i];
                sell = prices[i];
            }
            else{
                sell = prices[i];
            }
        }
        profit += (sell - buy);
        return profit;
    }
}
class Practice199{
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 4};
		Solution solution = new Solution();
		System.out.println(solution.maxProfit(prices));
	}
}