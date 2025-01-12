/*
ex1
0000
0010
--> 0010

0010
0010
--> 0000

0000
0001
--> 0001

ex 2
0100
0001
--> 0101

0101
0010
--> 0111

0111
0001
--> 0110

0110
0010
--> 0100


*/
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }
}