/*
only checking for smallest value
left is first value
right is last value
mid is middle vlaue
compare middle to left and right pointers instead of target gvalue
if the middle is greater than the  right pointer, move left pointer to mid + 1
if middle is less than r than move right pointer to mid - 1

[6, 7, 9, 15, 19, 2, 3] min = 3
[19,2,3] min = 2
[19] min = 2
*/
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int lowVal = Integer.MAX_VALUE;
        while(l <= r){
            if(nums[l] < nums[r]){
                lowVal = Math.min(lowVal, nums[l]);
            }
            int mid = l + (r -l)/2;
            lowVal = Math.min(lowVal,nums[mid]);
            if(nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r = mid -1; 
            } 
        }
        return lowVal;
    }
}