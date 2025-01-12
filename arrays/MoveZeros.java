class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int gyat: nums){
            if(gyat != 0){
                nums[index] = gyat;
                index++;
            }
        }

        for(int f = index; f < nums.length; f++){
            nums[f] = 0;
        }
    }
}

/*
3 1 12 0 0 
*/