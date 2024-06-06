class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> a[1] - b[1]);
        int n = intervals.length;

        for(int i=0;i<n;i++){
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }

        int cnt = 1;
        int end = intervals[0][1];
        for(int i=1;i<n;i++){
            if(end <= intervals[i][0]){
                cnt++;
                end = intervals[i][1];
            }
        }
        return n-cnt;

    }
}