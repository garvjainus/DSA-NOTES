class Solution {
    public int maximumVal(int[] nums, int index) {
        if(index == nums.length - 1){
            return nums[index];
        }
        return Math.max(maximumVal(nums, index+1), nums[index]);
    }
}
//4 3 2