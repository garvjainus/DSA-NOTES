class Solution {
    public int reverse(int x) {
        Stack<Integer> stack = new Stack<>();
        boolean isNeg = x < 0;
        if(x/10 == 0){
            return x;
        }
        int y = Math.abs(x); 
        while(y != 0){
            stack.push(y%10);
            y /= 10;
        }
        String reversed = "";
        while(!stack.isEmpty()){
            reversed = stack.pop() + reversed;
        }
        int reverse = 0;
        try {
            reverse = Integer.parseInt(reversed);
        } catch (NumberFormatException e){
            return 0;
        }
        if(isNeg){
            reverse *= -1;
        }
        return reverse;
    }
}