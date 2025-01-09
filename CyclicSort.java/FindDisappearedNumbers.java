class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        ArrayList<Integer> x = new ArrayList<Integer>();
        while(i < nums.length){
            int val = nums[i] - 1; //which index it should be at
            if(val < nums.length && nums[val] != nums[i]){ //check if number at current index is the same as the number at the correct index
                int temp = nums[i];
                nums[i] = nums[val];
                nums[val] = temp;
            } else {
                i++; //if already correct move right
            }
        }
        for(int k = 0; k < nums.length; k++){
            if(nums[k] != k + 1){
                x.add(k + 1);
            }
        }
        return x;
    }
}