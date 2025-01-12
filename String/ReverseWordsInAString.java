class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); //skips any amount of hitespace characters
        StringBuilder gyat = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            gyat.append(words[i]);
            if (i > 0) { 
                gyat.append(" ");
            }
        }
        return gyat.toString();
    }
}