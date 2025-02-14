class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }
        int maxLength = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i>= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                //have to track maxLength because the dp[i] updating is in the if statement and doesnt happen at every value of j relative to i
                //since it only happens when nums[j] > nums[i], dp[0] doesnt necesarilly hold the highest value or the maximum
                if(nums[j] > nums[i]){
                    //if you cant add it to the subseqeunce, just ge tthe max of the rest of the dp array so you can accurately represent the state accurately
                    //you update dp[i] at every index, so it becomes a different number at first value, doesnt stay as 1 for all of the inner loop 
                    //at every index i, it checks if an index j could be added to the subsequeunce, if not set it to the current index i 
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}