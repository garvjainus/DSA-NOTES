/*
5 7 7 8 8 10
8 8 10
left = 3
right = 5
mid = 4
8 8
left = 3
right = 4
mid = 3
left = 3
right = 3
mid = 3
8
if you want to find first index, you dont care about the values to the right of the value
opposite for last index
dynamically updates the index so itll just keep updating the firstindex/lastindex as you move pointers
if you do nums[mid-1] != target, index out of bounds at 0 
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int firstIndex = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target ){
                firstIndex = mid;
                right = mid -1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int l = 0;
        int r = nums.length -1;
        int lastIndex = -1;
        while(l <= r){
            int mid2 = l + (r - l)/2;
            if(nums[mid2] == target ){
                lastIndex = mid2;
                l = mid2 + 1;
            } else if (nums[mid2] < target){
                l = mid2 + 1;
            } else {
                r = mid2 - 1;
            }
        }
        return new int[]{firstIndex, lastIndex};
    }
}