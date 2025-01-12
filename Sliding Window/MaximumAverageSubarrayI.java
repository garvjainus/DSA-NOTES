class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double average = Integer.MIN_VALUE;
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(i >= k - 1){
                double newAvg = (double)sum/k;
                if(newAvg > average){
                    average = newAvg;
                }
                sum -= nums[left];
                left++;
            }
        }
        return average;
    }
}