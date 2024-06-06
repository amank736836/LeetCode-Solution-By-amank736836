class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , (a,b) -> {
            if(a[1] < b[1]){
                return -1;
            }
            else return 1;
        });


        int max = points[0][1];
        int n = points.length;

        int arrows = 1;
        for(int i=1;i<n;i++){
            if( max >= points[i][0] && max <= points[i][1]){
                continue;
            }else{
                arrows++;
                max = points[i][1];
            }
        }

        return arrows;

    }
}