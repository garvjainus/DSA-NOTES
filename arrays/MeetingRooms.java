/*
[0,30] [5,10] [15.20]
sort by starting time to compare adjacent meetings in time, not random order

not a valid meeting people can attend if end time of one of meeting is greater than the start time of the next
*/
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < intervals.length -1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}