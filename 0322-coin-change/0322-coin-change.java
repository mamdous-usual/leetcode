class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (coin <= i) {
                    int remainingAmount = i - coin;
                    int coinsNeededForRemaining = dp[remainingAmount];
                    int totalCoinsWithThisCoin = coinsNeededForRemaining + 1;

                    dp[i] = Math.min(dp[i], totalCoinsWithThisCoin);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}