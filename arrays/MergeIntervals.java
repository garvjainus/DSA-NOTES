class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int lastEnd = list.get(list.size() - 1)[1];
            int iterStart = intervals[i][1];
            if(intervals[i][0] <= lastEnd){
                list.get(list.size() -1)[1] = Math.max(iterStart, lastEnd); //we check the most recently added interval because it works chronologically, if [10,15] is addded, we should check that once for overlap because the next value we are checking will h ave a start time greater than 10 
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}