class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int index = -1;
        char minGreaterValue = Character.MAX_VALUE; //when looking for min, always set value to max value, when looking or max, always set to min value
        while(left <= right){
            int mid = left + (right-left)/2;
            if(letters[mid] < target){
                left = mid + 1;
            } else if (letters[mid] > target) {
                if(letters[mid] < minGreaterValue){
                    minGreaterValue = letters[mid];
                    index = mid; 
                }

                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        if(index == -1){
            return letters[0];
        }
        return letters[index];
    }
}