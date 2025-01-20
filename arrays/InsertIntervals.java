/*
1 3 6 8 12
4

the binary search's last iteration is when left == right. when this is true, they will once again complete the comparisons
since they both up end up where the number should be inserted, this number should be greater than the number you are inserting, since you have to shift that number and everything after to the right to insert it. therefore, the first condition will go through, and right will be one to the left of where you are inserting the number.
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = 0;
        int right = intervals.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int startTime = intervals[mid][0];
            int insertTime = newInterval[0];
            if(startTime > insertTime){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //left is now right before where we need to insert
        ArrayList<int[]> output = new ArrayList<>();
        for(int i = 0; i < left; i++){
            output.add(intervals[i]);
        }
        output.add(newInterval);
        for(int i = left; i < intervals.length; i++){
            output.add(intervals[i]);
        }
        ArrayList<int[]> list = new ArrayList<>();
        list.add(output.get(0));
        for(int i = 1; i < output.size(); i++){
            int lastEnd = list.get(list.size() - 1)[1];
            int iterStart = output.get(i)[1];
            if(output.get(i)[0] <= lastEnd){
                list.get(list.size() -1)[1] = Math.max(iterStart, lastEnd); //we check the most recently added interval because it works chronologically, if [10,15] is addded, we should check that once for overlap because the next value we are checking will h ave a start time greater than 10 
            } else {
                list.add(output.get(i));
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}