class Solution {
    public boolean canJump(int[] nums) {
        int maxJumps = nums[0] - 1;
        int target = nums.length - 1;
        //edge case checking
        if(nums.length == 1 || nums[0] >= target){
            return true;
        }
        if(nums[0] == 0){
            return false;
        }
        for(int i = 1; i < nums.length; i++){
            maxJumps = Math.max(maxJumps, nums[i]); //this allows us to ignore nums[i], because it gives us the amount of jumps we can use at any given point, if we have 3 and then 2 as the next value in the array, 3 steps will become 2 through decrement and still apply
            //only time you need to update the amount of jumps you can do at a given point is if the number of jumps at index i is greater than the maxjumps recorded before, as long as we keep decrementing maxjumps to keep track of how many jumps we can possibly do
            if(nums[i] == 0 && maxJumps == 0){
                break;
            }
            if(i + maxJumps >= target){
                return true;
            }
            
            maxJumps--; //iterating through the array means you are using one of your max jumps
        }
        return false;
    }
}