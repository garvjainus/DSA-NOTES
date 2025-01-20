/*
move my window until my sum is greater than or euqal to target
once its greater than or equal to target,
i have to move my window start until its no longer greater than or equal to target
and then resize my array with my right pointer
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int sum = 0;
        int output = Integer.MAX_VALUE;
        int winStart = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            while(sum >= target){ //do this instead of doing an if and a while inside, because we might find the minimum subarray when shrinking the array, so need to check 
                output = Math.min(output,i-winStart+1);
                sum -= nums[winStart];
                winStart++;
            }
        }
        if(output == Integer.MAX_VALUE){
            return 0;
        }
        return output;
    }
}