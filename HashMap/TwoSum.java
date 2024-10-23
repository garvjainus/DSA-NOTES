import java.util.HashMap;
/*
you add items to the hashmap at the end of the code because pairs can always be
 found from values before. if you cant find it from the values before, you will
  just look at the pair you missed in the future iterations.

in 3 2 4

if u check 3 2 only (because 4 hasnt been added yet), you will check 3 2 4 after
 because then 4 will be added.

by the time you reach the end of the array in iteration, you should have found
 the solution because you checked all the values BEFORE each iteration 
 throughout, and if not it was added to the hashmap. 
 so this way you dont skip anyelements or have to worry about indexes 
 being equal, because it isnt working based off of indexes but rather compliments
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> gyat = new HashMap<>();
    
        for (int i = 0; i < nums.length; i++) {
            int meow = nums[i]; 
            int complement = target - meow;
            
            if (gyat.containsKey(complement)) {
                return new int[]{i, gyat.get(complement)};
            } 

            gyat.put(meow,i);
        }
        
        return new int[]{0, 0}; 
    }
}
