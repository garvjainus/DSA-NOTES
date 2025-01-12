class Solution {
    public void reverseString(char[] s) {
        reverseStringHelper(s,0,s.length-1);

    }
    private void reverseStringHelper(char[] s, int left, int right){
        if(left >= right){
            return;
        }
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
        reverseStringHelper(s,left+1, right-1);
    }
}