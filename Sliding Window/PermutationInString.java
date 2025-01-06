/*
eidbaooo
ab

just do fixed size sliding window
*/
import java.util.Hashtable;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Hashtable<Character, Integer> map1 = new Hashtable<>();
        Hashtable<Character, Integer> map2 = new Hashtable<>();
        int left = 0;
        int req = 0;
        for(int i = 0; i < s1.length(); i++){
            char gyat = s1.charAt(i);
            map1.put(gyat, map1.getOrDefault(gyat,0)+ 1);
        }
        for(int right = 0; right < s2.length(); right++){
            char gyat = s2.charAt(right);
            map2.put(gyat, map2.getOrDefault(gyat,0)+ 1);
            int winLength = right - left + 1;
            if(winLength > s1.length()){
                char gyat1 = s2.charAt(left);
                if(map2.get(gyat1) == 1){ //remove it when its 1 instead of 0 because if its at 1 and you are rmoving it, it will no longer be in the window so u can remove the value
                    map2.remove(gyat1) ;
                } else {
                    map2.put(gyat1, map2.get(gyat1) - 1);
                }
                left++;
            }
            if(map1.equals(map2)){
                return true;
            }
        }
        return false;
    }
}