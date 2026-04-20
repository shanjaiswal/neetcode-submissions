/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return true;
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        Interval current = intervals.get(0);
        for (int i = 1; i<n; i++) {
            Interval ith = intervals.get(i);
            if (ith.start < current.end) {
                return false;
            }
            current = ith;
        }
        return true;
    }
}
