/*
at any index you have to choice to add something to the sum or not
*/
class Solution {
    private int totalSum = 0;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        boolean result = false;
        for(int num: nums){
            totalSum += num;
        }
        dp = new Boolean[nums.length + 1][totalSum/2 + 1];
        if (totalSum % 2 != 0) {
            return false;
        }
        return recursive(nums, 0, 0);
    }
    public boolean recursive(int[] nums, int i, int currSum){
        if(i >= nums.length || currSum > totalSum/2){
            return false;
        }
        if(dp[i][currSum] != null){
            return dp[i][currSum];
        }
        
        if(currSum == totalSum/2){
            return true;
        }
        
        boolean currSum1 = recursive(nums, i+1, currSum);
        boolean currSum2 = recursive(nums, i+1, currSum + nums[i]);
        
        if(currSum1 || currSum2){
            dp[i][currSum] = true;
        } else {
            dp[i][currSum] = false;
        }

        return currSum1 || currSum2;
        
    }
}