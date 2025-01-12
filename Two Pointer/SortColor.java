/*
create poitner on left and pointer on right
compare if left is greater than right
if so iterate left poitner
if not swap and iterate right pointer left 
*/
class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int iterator = 0;

        while(iterator <= p2 ){
            if(nums[iterator] < 1){
                int temp = nums[p1];
                nums[p1] = nums[iterator];
                nums[iterator] = temp; 
                p1++;
                iterator++;
                //have to wait until a number less than 0 can be put in p1 till we can confirm our iteration forward
            } else if (nums[iterator] > 1){
                int temp = nums[iterator];
                nums[iterator] = nums[p2];
                nums[p2] = temp; 
                p2--;
                //not necesarily a 0 so we cant iterate forward (cause we cant just move on without the left side beign full of zeros)
            } else if (nums[iterator] == 1){
                iterator++;
            }
        }
    }
}
