class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int left = 0;
        long sum = 0;
        long max = 0;
        for(int right = 0; right < n; right++){
            int val = nums[right];
            map.put(val, map.getOrDefault(val, 0) + 1);
            sum += val;
            while (map.get(val) > 1) {
                int dap = nums[left];
                map.put(dap, map.get(dap) - 1);
                if (map.get(dap) == 0) {
                    map.remove(dap);
                }
                sum -= dap;
                left++;
            }
            if (right - left + 1 == k) {
                max = Math.max(max, sum);
                int dap = nums[left];
                map.put(dap, map.get(dap) - 1);
                if (map.get(dap) == 0) {
                    map.remove(dap);
                }
                sum -= dap;
                left++;
            }
            
        }
        return max;
    }
}