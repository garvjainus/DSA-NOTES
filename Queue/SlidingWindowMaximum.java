import java.util.Deque;
import java.util.LinkedList;
/*
1 3 1 2 0 5
queue progression:
1 
3
3 1 
3 1 2 this is where it goes wrong, you cant add 2 to the right here itll be incorrect
explanation: you have to compare it to the value on the right most so that once you remove the max value for being oout of. bounds, the next value is the next greatest
1 2 0 //left most is NOT the greatest which contradicts the algoirthm

how it should be:
1
3
3 1
compare the value at right (2) to right value instead, since its greater, pop from right until its not
3 2 
3 2 0 
5
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        int left = 0;
        Deque<Integer> deq = new LinkedList<>();
        for(int right = 0; right < nums.length; right++){
            //want to get rid of all smaller values in the queue and make sure that values otuside of the window are not considered
            while(!deq.isEmpty() && deq.peek() < left){
                deq.pop();
            }
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[right]){
                deq.removeLast();
            }
            deq.add(right);

            if(right >= k - 1){
                output[left] = nums[deq.peek()];
                left++;
            }
        }
        return output;
    }
}