import java.util.Hashtable;
/*
fixed size sliding window
size = 10
win start at 0 (for loop through string)
win end at 9 if possible
store that substring in a hashtable if it doesnt exist, if it does then increment its frequency
increment the pointers until win end is at the end of the string, then break out of the loop
loop through hastable and find all substrings that other occur more than once and add them to a list and return 


*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() == 0 || s.length() < 10){
            return new ArrayList<String>();
        }
        int n = s.length();
        int winEnd = 9;
        Hashtable<String, Integer> allsubs = new Hashtable<>();
        for(int winStart = 0; winStart < n && winEnd < n; winStart++, winEnd++){
            String sub = s.substring(winStart, winEnd+1);
            allsubs.put(sub, allsubs.getOrDefault(sub, 0) + 1);
        }
        List<String> output = new ArrayList<>();
        for(String str: allsubs.keySet()){
            if(allsubs.get(str) > 1){
                output.add(str);
            }
        }
        return output;
    }
}