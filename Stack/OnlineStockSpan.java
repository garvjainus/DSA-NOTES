class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    /*
    so instead of storing the index of the number, you store the price and the span of the that price
    */
    public int next(int price) {
        int ans = 1;

        while(!st.isEmpty() && st.peek()[0] <= price){
            int[] val = st.pop();
            //you are basically adding previous spans.
            //why can you do this? because if a number is <= the current price, then all the things that were in its span would also be in the current price's span
            //so this basically backtracks and adds all the values 
            //monotnic stack means the values are stored in increasing order, meaning that 
            //if you use the previous values that are less than or equal to the value, you pop them and add their spans to the new price that will be appended after the while loop
            //this means the next value in the array can use it and add it 
            ans += val[1];
        }

        st.push(new int[]{price, ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);

 100 80 60 70 60 75 85
 1.  1. 1. 2. 1. 4. 6. 

 the span of a certain value is 1 + the span of the previous value
 */