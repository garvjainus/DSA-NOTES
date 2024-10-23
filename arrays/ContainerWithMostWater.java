/*
there needs to be a width and a height
height is the minimum of the two end points height 
width is the distance between the indices of the two endpoints
area is the height multiplied by the width 
if the area calculated is greater than the maxarea, update maxarea
move the pointer at which the min height is located

any problem try to get the logic first with plain english or pseudocode to help think the logic of the problem 
*/
class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length -1; 
        int maxArea = 0;

        while(p1 != p2){
            int height1 = Math.min(height[p1], height[p2]);
            int width = p2 - p1;
            int area = height1 * width;
            if(area > maxArea){
                maxArea = area;
            } 
            if(height1 == height[p1]){
                    p1++;
            } else {
                p2--; 
            } 
        }
        return maxArea;
    }
}