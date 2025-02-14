class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int x: nums){
            total += x;
        }
        int target = total/k;
        if(total%k != 0){
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return recursive(nums, used, k, 0, 0, target);
    }

    public boolean recursive(int[] nums, boolean[] used, int k, int j, int currSum, int target){
        if(k == 0){
            return true;
        }
        
        if(currSum == target){
            return recursive(nums, used, k-1, 0, 0, target);
        }

        if(j >= nums.length){
            return false;
        }
        //iterate to check all combinations from that index and return early if the subset fits requirements
         for (int i = j; i < nums.length; i++) {
            if (used[i] || currSum + nums[i] > target) continue; 
            
            used[i] = true;
            if (recursive(nums, used, k, i + 1, currSum + nums[i], target)) return true;
            used[i] = false; 
        }
        return false;
    }
}