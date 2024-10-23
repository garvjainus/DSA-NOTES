class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> gyat = new HashMap<>();
        for(char c: s.toCharArray()){
            gyat.put(c, gyat.getOrDefault(c, 0) + 1); // getOr Default initializes the values to 0 
            //before so its not Null Pointer Exceptioj
        }
        for(char c: t.toCharArray()){
            if(gyat.containsKey(c)){
                gyat.put(c, gyat.get(c) - 1);
            }
        }
        for(char count: gyat.keySet()){
            if(gyat.get(count) != 0){ // whole idea is u want to make sure the number of each letter is the same 
            //as well as their existence in each word
                return false;
            }
        }
        return true;
    }
}