/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // First sort by starting time in ascending order.
    // case1: [1, 2], [3, 4]
    // case2: [1, 5], [2, 3]
    // case3: [1, 10], [8, 14]
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        
        if (intervals.size() == 0) return res;

        Collections.sort(intervals, (Interval a, Interval b) -> a.start - b.start);

        Interval prev = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            // Mergable
            if (prev.end >= cur.start) {
                prev = new Interval(prev.start, Math.max(cur.end, prev.end));
            } else {
                res.add(prev);
                prev = cur;
            }
        }

        // Last interval
        res.add(prev);

        return res;
    }

}