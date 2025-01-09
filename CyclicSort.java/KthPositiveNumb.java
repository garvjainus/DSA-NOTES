/*
want to find the kth missing positive integer. should store missing ints from index 0 to index n-1.

how to find missing integerr?
k is just a number in the world right. it just states how many misisng numbers it wants us to look thoruhg

we can increment k by one everytime we find a missing number. it dynamically updates and will only stop when there are no more missing number
1 2 3 4  k = 2
k = 3
k = 4
k = 5
k = 6
now return k

2 3 4 7 11 k = 5
k = 6
k = 7
k = 8
k = 9
11 is greater than k
return k

why?
TO MAKE CLEAR: the total length of the sequence we are trying to calcualte till is the output (9 in example)
since the sequeunce is ONLY in increments of 1, we want to increment k until it equals that output
when does it equal that output? when it finds a value in nums that is bigger than the sequence length being iterated by 1.
think about it, the sequence is the numbers in the seuquence in the arrya + the numbers in the sequence NOT in the array.
so if you iterate the k times as there is k numbers in the sequeunce in the array, you are left with the kth missing number
idk if that makes sense
--------------------------------
cause remember that we are basically just working with indexes here, the actual values at the indices doesnt matter for our output
so we are just trying to push the k value k times to reach the kth missing positive number
when do we push it?
think of it like this: we start by assuming that all values in the sequence up to the output are missing. so 1, 2, 3, 4. right? and if we find a number that is actaully supposed to be in that sequence (<=k) we increment k to push it forward. now the reason we increment k++ is to maintain the sequence. we dont want to just go up to k, we want to keep iterating k to reach the end of the sequeuce that is defined by the elements actually in the array
once we've reached a number greather than k, the gap in sequence is now more than +1 so we can stop



2 3 4 7 11
7 11
11

*/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int right = arr.length - 1;
        int left = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] - mid - 1 < k ){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + k + 1; //why return this?
    }
}