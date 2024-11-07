/*

2 2 1 1 1 3 3 
this is an uinvaid testcase cause its asking for majoirty of ARRAY not most appeared
*/
class Solution {
    public int majorityElement(int[] nums) {
        int count1 = 0;
        int cand = nums[0];
        for(int num: nums){
            if(count1 == 0){
                cand = num;
            }
            if(num == cand){
                count1++;
            } else {
                count1--;
            }
        }
        return cand;
    }
}