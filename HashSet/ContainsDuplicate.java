class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1 ){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums){
            if(!set.contains(n)){
                set.add(n);
            } else {
                return true;
            }
        }
        return false;
    }
}
//very simple