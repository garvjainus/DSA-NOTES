/*
1 1 2 3 3 4 4 8 8
its based on subarray length
we know the answer has to be on the left because 3 has its double before it in a 4 length subarray
that means that there is an odd number of other elements (3) and thus a one pair has to exist
if middle doesnt have the same element before or after reutrn the element
if middle has the same element before move the right pointer to mid - 1
if middle has the same element as after move the left pointer to mid + 1

if (nums.length - 1) - mid %2 == 1
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
       int left = 0;
       int right = nums.length - 1;
       while(left <= right){
          int mid = left + (right-left)/2;
          if(mid%2 == 0){
            if(mid -1 >= 0 && nums[mid-1] == nums[mid]){
                right = mid -1;
            } else if(mid + 1 < nums.length && nums[mid+1] == nums[mid]){
                left = mid + 1; 
            } else {
                return nums[mid];
            }
          } else {
            if(mid -1 >= 0 && nums[mid-1] == nums[mid]){
                left = mid + 1;
            } else if(mid + 1 < nums.length && nums[mid+1] == nums[mid]){
                right = mid - 1; 
            } else {
                return nums[mid];
            }
          }
       }
       return -1;
    }
}