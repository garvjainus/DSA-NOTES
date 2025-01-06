/*
want to find every VALID substring
substring is valid is it has two distinct fruits
use hashtable to store every fruit with a frequency
as long as the size of the hashset is less than 3, valid substring
once its not, slide the window
*/

import java.util.Hashtable;
class Solution {
    public int totalFruit(int[] fruits) {
        Hashtable<Integer, Integer> currFruits = new Hashtable<>();
        int left = 0;
        int pickedFruits = 0;
        int output = 0;
        for(int right = 0; right < fruits.length; right++){
            currFruits.put(fruits[right], currFruits.getOrDefault(fruits[right], 0) + 1);      
            pickedFruits += 1;
            if(currFruits.size() > 2){
                pickedFruits -= 1;
                currFruits.put(fruits[left], currFruits.get(fruits[left]) -1);
                if(currFruits.get(fruits[left]) == 0){
                    currFruits.remove(fruits[left]);
                }
                left++;
            }
            output = Math.max(pickedFruits, output);
        }
        return output;
    }
}