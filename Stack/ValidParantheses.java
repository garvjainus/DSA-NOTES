/*
the whoel idea is taht you push opening brackets/parantehses and pop if closing and check if its empty at the end (if its matched then itll be zero at the end, so you return it). t
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> gyat = new Stack<>();
        char[] x = s.toCharArray();
        if(x.length % 2 != 0 ){
            return false;
        }
        for(int i = 0; i < x.length; i++){
            if(x[i] == '('|| x[i] == '{' || x[i] == '['){
                gyat.push(x[i]);
            } else {
                if(gyat.isEmpty()){
                    return false;
                }
                if(x[i] == ')' && gyat.peek() == '('){
                    gyat.pop();
                    continue;
                }

                if(x[i] == '}' && gyat.peek() == '{'){
                    gyat.pop();
                    continue;
                } 

                if(x[i] == ']' && gyat.peek() == '['){
                    gyat.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        return gyat.isEmpty();
    }
}