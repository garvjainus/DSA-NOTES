class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < output.length; i++){
            int val = temperatures[i];
            while(!st.isEmpty() && val > temperatures[st.peek()]){
                int prev = st.pop();
                int idx = i - prev;
                output[prev] = idx;
            }
            st.push(i);
        }
        return output;
    }
}