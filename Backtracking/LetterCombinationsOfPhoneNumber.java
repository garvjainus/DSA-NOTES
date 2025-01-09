import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    ArrayList<String> output;
    HashMap<Character,String> letters;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        output = new ArrayList<String>();
        letters = new HashMap<>();
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
        backtrack(0, "", digits);
        return output;
    }

    public void backtrack(int i, String s, String str){
        if(s.length() == str.length()){
            output.add(s);
            return;
        }
        String characters = letters.get(str.charAt(i));
        for(char c: characters.toCharArray()){
            s += c;
            backtrack(i + 1, s, str);
            s = s.substring(0, s.length() -1);
        }
    }
}
/*
2-abc
3-def
ad ae af
*/