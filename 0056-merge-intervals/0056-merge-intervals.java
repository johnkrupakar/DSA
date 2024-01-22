class Solution {
    public int[][] merge(int[][] intervals) {
       int n = intervals.length;

        // Custom sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[][] ans = new int[n][2];
        int count = 0;

        for (int i = 0; i < n; i++) {
            // If the current interval does not lie in the last interval
            // Check if the current interval start is greater than the
            // last interval end, then insert the current interval in the ans

            if (count == 0 || intervals[i][0] > ans[count - 1][1]) {
                ans[count][0] = intervals[i][0];
                ans[count][1] = intervals[i][1];
                count++;
            }
            // If the current interval lies in the last interval
            // Update the last interval with the max of last interval and current interval
            else {
                ans[count - 1][1] = Math.max(ans[count - 1][1], intervals[i][1]);
            }
        }

        return Arrays.copyOf(ans, count);
    }
}