class Solution {
    public int bitwiseComplement(int n) {
        if(n==0){
            return 1;
        }
        //need to find the length of the binary code and xor it by the value if all the 0's were 1's + 1
        int curr = n;
        int bit = 1;
        while(curr != 0){
            n = n ^ bit;
            bit = bit << 1;
            curr = curr >> 1; //just to make sure it goes to 0, will keep shifting until there are no more 1's
        }
        return n;

    }
}