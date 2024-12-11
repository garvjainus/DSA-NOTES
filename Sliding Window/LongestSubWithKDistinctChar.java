import java.util.Hashtable;
/*
eceba
e
*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0){
            return 0;
        }
        Hashtable<Character, Integer> map = new Hashtable<>();
        int n = s.length();
        int winStart = 0;
        int winLength = 0;
        int longest = 0;
        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr,0) + 1);
            while(map.size() > k){
                map.put(s.charAt(winStart), map.get(s.charAt(winStart)) - 1);
                if(map.get(s.charAt(winStart)) == 0){
                    map.remove(s.charAt(winStart));
                }
                winStart++;
            }
            winLength = i - winStart +1 ;
            longest = Math.max(winLength,longest);
        }
        return longest;

    }
}