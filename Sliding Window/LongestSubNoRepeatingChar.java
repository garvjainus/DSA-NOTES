import java.util.Hashtable;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int n = s.length();
        int winStart = 0;
        int longest = 0;
        int winLength = 0;
        int i = 0;
        Hashtable<Character, Integer> lastSeenAt = new Hashtable<>();
        for(i = 0; i < n; i++){
            if(!lastSeenAt.containsKey(s.charAt(i))){
                lastSeenAt.put(s.charAt(i), i);
            } else {
                if(lastSeenAt.get(s.charAt(i)) >= winStart){
                    winLength = i - winStart; //not including the repeated character because indexes are naturally shifted by 1 cause it starts at 0
                    if(longest < winLength){
                        longest = winLength;
                    }
                    winStart = lastSeenAt.get(s.charAt(i)) + 1; //set start to after the last seen repeated character
                }
                lastSeenAt.replace(s.charAt(i), i);
            }
        }
        if(longest < i - winStart){
            longest = i - winStart;
        }
        return longest;
    }
}