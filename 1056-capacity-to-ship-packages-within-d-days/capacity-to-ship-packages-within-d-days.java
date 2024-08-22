class Solution {

    public boolean check(int mid,int weights[],int days){
        int limit = 0;
        int time = 1;
        for(int weight : weights){
            if(limit + weight > mid){
                limit = weight;
                time++;
            }else{
                limit += weight;
            }
        }
        return time <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int weight : weights){
            end += weight;
            start = Math.max(start,weight);
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(mid,weights,days)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}