/*
create new array. add each element to the element +k in the second array

k = 3
i = 0 --> 3
i = 1 --> 4
i = 2 --> 5
i = 3 --> 6
i = 4 --> 0
i = 5 --> 1
i = 6 --> 2 
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int[] gyat = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            gyat[i] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            //how do you figure out this formula?
            nums[(i+k)%nums.length] = gyat[i];
        }
    }
}