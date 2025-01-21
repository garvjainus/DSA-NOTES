//dp soluiuton botton up,tabulation
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }
}

/*
top down approach: memoization

class Solution {
    public int fib(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return fibonacciNumber(n, map);
    }

    private int fibonacciNumber(int n, HashMap<Integer, Integer> map){
        int result;
        if(map.containsKey(n)){
            result = map.get(n);
        } 
        if(n <= 1){
            result = n;
        } else {
            result = fibonacciNumber(n-2, map) + fibonacciNumber(n-1, map);
        }
        map.put(n, result);
        return result;

    }
}
*/