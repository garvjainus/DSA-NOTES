/*
create new sum array same size as matrix
iterate through rows and cols of the matrix and add the matrix value, the value above, and the value to the left, and subtract the sum of the i-1 j-1 to get the prefix sum matrix
iterate through the sum matrix and if its less than k update the largest value
return that value
--- this aproach above only addresses rectangles from 0 0 to i j. this method below compresses columns into one column that can be checked for the max subarray sum. this way you check all possible rectangles

ask chatgpt to visualize if you dont get it

*/
class Solution {
    int answer = Integer.MIN_VALUE;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // * * *
        // * * *
        // * * * 
        // compressing each set of columns into one row, finding the maximum sum subarray in that 1d row, and since it is based on the sum of the columns from before, you are checking every possible rectangle 
        // We'll compress across the smaller dimension to reduce time if possible
        // but for simplicity, let's just assume standard col-compression:
        // (left, right) define the columns that we are combining.
        for (int left = 0; left < cols; left++) {
            // rowSum[r] will hold the sum of elements in row 'r' from col left..right
            int[] rowSum = new int[rows];

            for (int right = left; right < cols; right++) {
                // Update rowSum by adding the values from the 'right' column
                for (int r = 0; r < rows; r++) {
                    rowSum[r] += matrix[r][right];
                }

                // Now find the maximum subarray sum in rowSum no larger than k
                maxSubArrayNoMoreThanK(rowSum, k);

                // If we ever hit exactly k, we can short-circuit because
                // that's the best we can do.
                if (answer == k) {
                    return k;
                }
            }
        }
        return answer;
    }

    /**
     * Finds the maximum subarray sum in 'arr' that does not exceed k.
     * This version is the simple O(n^2) approach with 1D prefix sums.
     */
    private void maxSubArrayNoMoreThanK(int[] arr, int k) {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(0); //this is for the prefix sum calculations
        int runningSum = 0;
        for(int num: arr){
            runningSum += num;
            // we want the runningSum - a previous sum from an index before i to be <= k
            // can reorganize this mathematicaly phrase into p >= runningSum - k
            // so we want the smallest value of p possible that is >= runningSum - k
            // tree.ceiling returns the smallest element greater than the value passed in
            // we use a treeset because it is ordered by nature
            Integer x = tree.ceiling(runningSum-k);
            if(x != null){
                answer = Math.max(answer, runningSum-x); //if x is not null, meaning there is some subaray at some index that is no zero that has a previous prefix sum >= runningSum-k but as small as possible 
                //we use it to calculate the sum that is as big as possible, runningSum - that previous sum (x)
            }
            tree.add(runningSum);
        }
    
    }
}