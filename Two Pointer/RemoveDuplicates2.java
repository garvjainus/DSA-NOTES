class Solution {
    public int removeDuplicates(int[] nums) {
        int updatePoint = 2;
        if(nums.length < 2){
            return 1;
        }
        for(int i = updatePoint; i < nums.length; i++){
            if(nums[updatePoint-2] != nums[i]){ //use updatepoint as aconstnat index tracker for where you want to update the values, and i as the constant iteration. same idea as the first version
                nums[updatePoint] = nums[i];
                updatePoint++;
            }
        }
        return updatePoint;
    }
}