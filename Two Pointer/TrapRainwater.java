/*
store number of rain water in a var
if i find a height greater than 0, look through rest of the array for height greater than 0
for first four elements, output would be min of left hiehgt and right height times the right index - index
two pointers left and right

brute force:
if you find the left max and right max at every pointer and substract the height at index i to figure out hwo much water you can store at index i
*/
class Solution {
    /*
    public int trap(int[] height){
        //store all max heights at left and right, find min, and use that very simple approach
        int sum = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0, r = height.length - 1; i < height.length; i++, r--){
            left[i] = leftMax;
            right[r] = rightMax;
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[r]);
        }
        for(int i = 0; i < height.length; i++){
            int val = Math.min(left[i], right[i]);
            sum += Math.max(0,val - height[i]);
            
        }
        return sum;
    }
    */
    
    public int trap(int[] height) {
        //what this is saying is that you have a max left and right at any given value
        //how do you what your min heeight is at a given r or l? 
        //you know that the min height will be the max left for left pointer and max right for right pointer becuase the smaller one is the BOTTLENECK
        //no matter how big of a value ther eis on the other side, the smaller value (which is what the conditional is ch ecking) will always triump in math.min
        // what if there is a smaller value? for example 0?
        //it doesnt matter because heights are global, if theres a smaller value, the higher value wille ven out and allow for the storage of water
        //therefore you can always 
       int sum = 0;
       int l = 0;
       int r = height.length - 1;
       int leftMax = height[0];
       int rightMax = height[height.length-1];
       while(l < r){
        if(height[l] < height[r]){
            sum += Math.max(0, leftMax-height[l]);
            leftMax = Math.max(leftMax, height[l]);
            l++;
        } else {
            sum += Math.max(0, rightMax - height[r]);
            rightMax = Math.max(rightMax, height[r]);
            r--;
        }
       }
       return sum;
    }
    
}