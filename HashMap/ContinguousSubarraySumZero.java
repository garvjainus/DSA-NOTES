import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public static int[] checkSubarraySum(int[] nums) {
        HashMap<Integer, Integer> jacksparrow = new HashMap<>();
        int curr = 0;
        int index1 = -1;
        int index2 = -1;
        ArrayList<Integer> selenagomez = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            curr += nums[i];
            selenagomez.add(nums[i]);
            //curr, i NO LONGER EXISTS --> curr, j --> if statement still true, but indexes are wrong cauhse of the overwriting
            if(curr == 0 || jacksparrow.containsKey(curr)) {
                index1 = jacksparrow.get(curr)+1;
                index2 = i;
                break;
            }

            jacksparrow.put(curr, i);
        }
        int[] liampayne = new int[index2-index1+1];
        for(int i = index1; i <= index2; i++){
            liampayne[i - index1] = selenagomez.get(i);
            //i - index1 accoutns for the difference in indices
        }
        return liampayne;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.checkSubarraySum( new int[]{2, 4, -2, 1, -3, 5, -3})));

    }
}
