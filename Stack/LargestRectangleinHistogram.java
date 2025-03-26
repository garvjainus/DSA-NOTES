class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;

        // we need to create a monotonic stack here
        for(int i = 0; i <= heights.length; i++){
            //can be any negative number, you are doing this to deal with whatever is left over in the stack after the last iteration, thats why you do <= so you can do one more and make the while loop true and deal with the rest of the values in the stack
            int currHeight = i == heights.length ? -2 : heights[i];

            while(!st.isEmpty() && heights[st.peek()] > currHeight){
                int val = st.pop();
                int height = heights[val];
                //int width = st.isEmpty() ? i : i - val ;
                // 4 - 2 = 2
                //watch neetcode video: 12 min, basically there could be a gap between i and st.peek()if you pop the values in between in previous iterations
                //if the stack is empty, you know that the last element you popped is the minimum element
                //if at any point you added something smaller than the minimum, it would still be in the monontonic stack
                int width = st.isEmpty() ? i : (i - (st.peek() + 1));
                if(st.isEmpty()){
                    System.out.println(i);
                }
                max = Math.max(max, width * height);
            }

            st.push(i);
        }
        return max;
    }
}