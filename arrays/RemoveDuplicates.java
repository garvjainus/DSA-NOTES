/*
for loop starting at i = 1
have a variable for the upadte point
look at every element
if new value is found, set new value to indice and incrememnt update point, increment a k counter as well to return at end
return k
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int updatePoint = 1;//cuz first value is guaranteed to be unique
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[updatePoint] = nums[i];
                updatePoint++;
            }
        }
        return updatePoint;
    }
}