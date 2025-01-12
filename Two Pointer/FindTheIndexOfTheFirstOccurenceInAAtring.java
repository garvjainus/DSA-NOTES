class Solution {
    public int strStr(String haystack, String needle) {
        int left = 0;
        int len = needle.length();
        StringBuilder output = new StringBuilder();
        if (needle.length() > haystack.length()) {
            return -1; 
        }
        for(int right = 0 ; right < haystack.length(); right++){
            output.append(haystack.charAt(right));
            if(output.length() > len){
                output.deleteCharAt(0);
                left++;
            }
            if(output.toString().equals(needle)){
                return left;
            }
        }
        return -1;
    }
}