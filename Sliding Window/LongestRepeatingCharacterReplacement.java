import java.util.Hashtable;
class Solution {
    public int characterReplacement(String s, int k) {
       Hashtable<Character, Integer> map = new Hashtable<>();
       int left = 0;
       int output = Integer.MIN_VALUE;
       for(int right = 0; right < s.length(); right++){
            char val1 = s.charAt(right);
            char val2 = s.charAt(left);
            map.put(val1, map.getOrDefault(val1, 0) + 1);
            char max = '\0';
            int maxVal = Integer.MIN_VALUE;
            for(char c: map.keySet()){
                if(map.get(c) > maxVal){
                    max = c;
                    maxVal = map.get(c);
                }
            }
            int winLength = right - left + 1;
            if(winLength - maxVal > k){
                map.put(val2, map.get(val2) - 1);
                left++;
            }
            output = Math.max(output, right - left + 1);
       }
       return output;
    }
}