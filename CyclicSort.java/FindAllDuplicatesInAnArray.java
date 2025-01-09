class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            System.out.println(nums[i]);
            System.out.println(i);
            int val = nums[i] - 1; //target index for current number
            if(nums[val] != nums[i]){ //if the current number is not at the target index, swap
            //just dont do val != i, trust
                int temp = nums[i];
                nums[i] = nums[val];
                nums[val] = temp;
            } else {
                i++;
            }
        }
        for(int k = 0; k < nums.length; k++){
            if(nums[k] != k + 1){
                output.add(nums[k]); // sorts and leaves duplicates at the end, not consecutively
                // 1 1 2 becomes 1 2 1 so this check works
            }
        }
        return output;
    }
}