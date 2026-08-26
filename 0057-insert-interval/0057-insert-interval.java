class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            // 1. Current interval is completely BEFORE newInterval
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            }

            // 2. Current interval is completely AFTER newInterval
            else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval;
            }

            // 3. They overlap
            else {
                newInterval[0] =
                    Math.min(newInterval[0], interval[0]);

                newInterval[1] =
                    Math.max(newInterval[1], interval[1]);
            }
        }

        // Add whatever newInterval became
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}