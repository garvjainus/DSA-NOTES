/*
need largest segment of array in terms of sum
it is sequential meaning no hashmap 

fast way: 
if CURRENT SUM is negative, the next number will be smaller than it already is therefore it is not contributing to a sum abnd u can skip that john 
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0; 
        for(int num: nums){
            curr += num;
            max = Math.max(curr, max);
            if(curr < 0){
                curr = 0;
            }
        }
        return max;
    }
}