class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x ;
        while(left <= right){
            int mid = left + (right-left)/2;
            long sq = (long)mid * mid;
            if(sq > x){ 
                right = mid - 1;
            } else if (sq == x){
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return right; //smallest number with square less than or equal to x, because at last iteration (left <= right) right is moved to the left so that the loop can end, meaning that right stores the last number that was less than or equal to x
    }
}