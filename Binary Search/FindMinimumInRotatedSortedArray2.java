

/*
objective: find SMALLEST value, so look for smaller part of the sorted array

3 0 1 3

1 10 10 10 10
10 1 10 10 10 
10 10 1 10 10 
10 10 10 1 10
10 10 10 10 1

1 2 3 4 5
5 1 2 3 4
4 5 1 2 3
3 4 5 1 2
2 3 4 5 1

min = 1 
set it to the least of left and right
then set it to the least of that and mid
now check if mid > right 
move left to mid + 1
if mid is less than right 
move right to mid - 1
when you are not returning a value, you can do left < right and just return the array value at left or right cause its singled down to one value
*/
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){ // while loop will end left == right, which means ONE element, you get to the smallest element so you can return either left or right
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1; //could be left ++ as well, but if the lowest value is on the left, it wont be skipped because this only occurs when nums[mid] > nums[right] which only happens when the smallest value is in that range, think rotation, if you rotate an array, the smallest number can only exist on the right if mid is greater than right. if this if statement doesnt go off ( which it wont if the smallest value is on the left) only thr right pointer gets moved until you get to the smallest element on the right, in which case the left will move until its the only element left 
            } else {
                right--; //move slowly so you dont skip it if its equal 
            } 
        }
        return nums[right]; //can return min and track min of left right and mid at every iteration, or  nums[left] doesnt matter
    }
}
