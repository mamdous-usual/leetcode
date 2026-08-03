class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++) {
            int currentPrice = prices[i];

            int currentProfit = currentPrice - minPrice;

            if(currentPrice < minPrice) {
                minPrice = currentPrice;
            } else if(currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }

        return maxProfit;
    }








    /*
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i=0; i<prices.length - 1; i++) {
            for(int j=i+1; j<prices.length; j++) {
                int currentProfit = prices[j] - prices[i];

                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }
    */
}