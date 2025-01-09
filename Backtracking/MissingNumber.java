class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int val = nums[i];
            if(nums[i] >= 0 && val < nums.length && val != i){
                int temp = nums[i];
                nums[i] = nums[val];
                nums[val] = temp;
            } else {
                i++;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j){
                return j;
            }
        }
        return nums[nums.length - 1] + 1;
        
    }
}