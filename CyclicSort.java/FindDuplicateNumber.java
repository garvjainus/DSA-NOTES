class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int val = nums[i];
            if( nums[val] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[val];
                nums[val] = temp;
            } else {
                i++;
            }
        }
        for(int k = 0; k < nums.length; k++){
            if(nums[k] != k){
                return nums[k];
            }
        }
        return nums.length - 1;
    }
}