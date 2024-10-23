class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int leftProduct = 1; 
        for(int i = 0; i < nums.length; i++){
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1; 
        for(int i = nums.length - 1; i >= 0; i--){
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;


    }
}

//you update output before updating product becuase you want to EXCLUDE 
//the current value. multipying by 1 is valid because u just want to make 
//it the same number intiialyl on right and left side. you dont need to 
//update until after so it can exclude the next number as well 