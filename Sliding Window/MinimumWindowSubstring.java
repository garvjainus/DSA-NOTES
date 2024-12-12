import java.util.Hashtable;
/*
add all characters of t to hashtable
start at win start, keep iterating until you create a substring that contains all the values in the hashtable
update minimum window start and end index (need to return subtring)
update left pointer until you reach next value that is in hashtable

ADOBECODEBANC
ADOBEC
*/
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        Hashtable<Character, Integer> map = new Hashtable<>();
        Hashtable<Character, Integer> map2 = new Hashtable<>();
        int winStart = 0;
        int startFinal = 0;
        int endFinal = 0;
        int count = 0;
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) + 1);
        }
        for(int i = 0; i < m; i++){
            char curr = s.charAt(i);
            map2.put(curr, map2.getOrDefault(curr,0) + 1);
            if(map.containsKey(curr) && map2.get(curr).equals(map.get(curr))){ //the frequency of once char = frequency of the other one
                count++;
            }
            while(winStart < m && count == map.size()){
                if(i - winStart + 1 < shortest){
                    startFinal = winStart;
                    endFinal = i;
                    shortest = i - winStart + 1;
                }
                char gyat = s.charAt(winStart);
                if(map.containsKey(gyat)){
                    map2.put(gyat, map2.get(gyat) - 1); 
                    if(map2.get(gyat) < map.get(gyat)){ //no longer has all the chars in t 
                        count--;
                    }
                    
                }
                winStart++;
            }
        }
        return shortest == Integer.MAX_VALUE ? "" : s.substring(startFinal, endFinal + 1);
    }
}