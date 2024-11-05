/*
do this as a 1d array but in 2d

row can be calcultaed by dividing by cols
cols can be calculated by modulus cols 

rest of logic is the same
dont forget overflow: (left - (right - left))/2
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int r = rows * cols - 1;
        while(l <= r){
            //calculated this way to avoid overflow. if you do l+(r-1)/2 it works cause it is mathematically the same thing. however,
            //(l+(r-1))/2 is not the same. if uu distribute the + you just get r/2 which isnt right. needs to be l+ --> sepearte calc r-l/2. if you
            //do common denom, they are the same math equations in reality 
            //THIS AVOIDS OVERFLOW BY DIVING THE LARGE VALUE SIGNIFICANTLY BEFORE ADDING TO AVOID OVERFLOW
            int mid = l + (r-l)/2;
            //you divide both by cols here because the actual number of values in a row in a 2d array is based on cols not rows, a row can have any number of values
            //you want to see how many cols can fit in mid, so you can see which row to map it to. you also want to see what is the remainder so you know the col index
            int row = mid/cols;
            int col = mid%cols;
            //have to use newly calculated row and col vars
            int midV = matrix[row][col];
            if(midV == target){
                return true;
            } else if (midV < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}