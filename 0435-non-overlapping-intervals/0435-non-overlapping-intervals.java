
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int i = 1;
        int count = 0;

        while (i < n) {

            if (intervals[i - 1][1] > intervals[i][0]) {
                count++;

                if (intervals[i - 1][1] > intervals[i][1]) {
                    intervals[i - 1] = intervals[i];
                } else {
                    intervals[i] = intervals[i - 1];
                }
            }

            i++;
        }

        return count;
    }
}
