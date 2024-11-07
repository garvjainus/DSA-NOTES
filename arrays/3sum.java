class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue; //goes to next iteration and skips duplicate values (1,1,1 eg)
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                // theres one combination of these three specific numbers taht adds up to zero. you do j++ and k-- after finding the right sum cause if j+1 and same k gives u zero, its duplicates. so since you cehck for duplicates, you cankeep checking for potential pairs. if the sum ISNT 0 then you move the pointers to make sure all duos are checked. but if the sum IS 0 you know that the remaining pairs have to be DIFFERENT than the j and k that gave you the pair, so you iterate both 
                if(sum == 0 ){
                    output.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while(j < k && nums[j] == nums[j+1]){
                        j++; //moves past duplicate combinations (2,2,0 -1, -1)
                    }
                    while(j < k && nums[k] == nums[k-1]){
                        k--; //moves behind duplicate combinations (2,2,0 -1, -1)
                    }
                    j++; //we increment both because since its sorted, getting to 0 again without dupe pair would 
                    //be impossible if we just increment one. to find a new pair, you have to increment both
                    //this is considering duplicates have already been skipped with the while loops 
                    k--;
                } else if (sum > 0){
                    k--; //sorted array, so if sum is too big want to move back to make smaller
                } else {
                    j++; //same logic, if sum is too small, want to move forward to make bigger
                }
            }
        }

        return output;
    }
}