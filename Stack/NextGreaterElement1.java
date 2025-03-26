class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[nums1.length];
        for(int i = 0; i < output.length; i++){
            output[i] = -1;
            map.put(nums1[i], i);
        }

        for(int i = 0; i < nums2.length; i++){
            int val = nums2[i];
            while(!stack.isEmpty() && val > stack.peek()){
                int curr = stack.pop();
                int idx = map.get(curr);
                output[idx] = val;
            }
            if(map.containsKey(val)){
                stack.push(val);
            }
        }
        return output;
    }
}