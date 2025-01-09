import java.util.ArrayList;
class Solution {
    List<List<Integer>> output;
    int tar;
    int[] vals;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        output = new ArrayList<List<Integer>>();
        tar = target;
        vals = candidates;
        backtrack(0, 0, new ArrayList<Integer>());
        return output;
    }
    public void backtrack(int i, int curr, ArrayList<Integer> subset){
        if(curr == tar){
            output.add(new ArrayList<Integer>(subset));
            return;
        } else if (curr > tar){
            return;
        }
        for(int j = i; j < vals.length; j++){
            subset.add(vals[j]);
            backtrack(j, curr + vals[j], subset);
            subset.remove(subset.size() - 1);
        }
    }
}