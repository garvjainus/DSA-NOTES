import java.util.ArrayList;
class Solution {
    List<List<Integer>> output;
    int[] vals;
    int k1;
    public List<List<Integer>> subsets(int[] nums) {
        output = new ArrayList<List<Integer>>();
        vals = nums;
        for(int k = 0; k < nums.length + 1; k++){
            k1 = k;
            backtrack(0, new ArrayList<Integer>());
        }
        return output;
    }
    public void backtrack(int i, ArrayList<Integer> subset){
        if(subset.size() == k1){
            output.add(new ArrayList(subset));
            return;
        }
        for(i = i; i < vals.length; i++){
            subset.add(vals[i]);
            backtrack(i + 1, subset);
            subset.removeLast();
        }
    }
}