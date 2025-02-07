class Solution {
    public int coinChange(int[] coins, int amount) {
        //why is this not 2d array
        int[] dp = new int[amount + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = 100000000;
        }
        //dp array is tracking the min coins to get that sum, it takes 0 coins to get a sum of 0
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin: coins){
                //what's the recursive relation?
                //we check at every coin for a dp value
                // for example at dp[7] (min coins to get a sum of 7)
                // we ask what is the lowest amount of coins we can do ?
                // 1 + dp[7 - coin]
                //why? 1 cause we are adding the current coin to the count, and dp[7-coin] because if we use that coin, we need to see what the minimum amount was to get to the sum minus that coins value
                //we check dp[i] in the line below because we are going through every coin, so we want the smallest value
                if(coin <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
                
            }
        }
        return dp[amount] > amount || dp[amount] < 0 ? -1 : dp[amount];

    }
}