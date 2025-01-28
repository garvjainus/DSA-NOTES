class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
        Yes, that's correct! The extra index in the array exists because:

The second-to-last index in arr (i.e., arr[arr.length - 2]) represents the minimum cost to get to the final step of the stairs (the last index in cost).
From the final step (last index in cost), you have the option to take one step directly to the "top of the stairs," which is represented by the extra index (arr[arr.length - 1]).

        */
        int[] arr = new int[cost.length+1];
        for(int i = 2; i < arr.length; i++){
            //we add arr[i-2] and arr[i-1] because at any given index we are calculatign the minimum cost to GET to that point, not the cost to get from there to current index as well which is just the price of that index
            int oneMin = cost[i-1] + arr[i-1];
            int twoMin = cost[i-2] + arr[i-2];
            arr[i] = Math.min(oneMin, twoMin);
        }
        return arr[arr.length-1];
    }
}