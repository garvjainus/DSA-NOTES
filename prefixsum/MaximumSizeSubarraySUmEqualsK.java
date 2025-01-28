class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n];
    }
}
/*
n = 4
4 3 2 1
class Solution {
    int count;
    public int climbStairs(int n) {
        Integer[] arr = new Integer[n + 1];
        return climb(n, arr);
    }
    private int climb(int n, Integer[] arr){
        if(n==0){
            return 1;
        } else if (n < 0){
            return 0;
        }
        if(arr[n] != null){
            return arr[n];
        }
        arr[n] = climb(n-2, arr) + climb(n-1, arr);
        return arr[n];
    }
}
*/