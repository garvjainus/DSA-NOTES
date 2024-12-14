/*
convert whole string to the string without empty spaces and nonalphanumeric characters (how? .trim()?)
recursion:
maybe call function on the other side of the array (eg, n and s.length - 1 - n)
for loop:
check if the character at n is the same as the character at s.length - 1 - n, if so continue, if not return false
return true as the last statement
*/
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        return isPalindromeHelper(s, 0, s.length()-1);
    }
    private boolean isPalindromeHelper(String s, int left, int right){
        if(left >= right){
            return true;
        }
        if (!Character.isLetterOrDigit(s.charAt(left))) {
            return isPalindromeHelper(s, left + 1, right);
        }
        if (!Character.isLetterOrDigit(s.charAt(right))) {
            return isPalindromeHelper(s, left, right - 1);
        }
        if(s.charAt(left) != s.charAt(right)){
            return false;
        }
        return isPalindromeHelper(s, left +1, right -1);
    }
}