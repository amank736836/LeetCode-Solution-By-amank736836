class Solution {
    
    public boolean function(int[] arr, int m, int mid){
        int count = 1;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - prev >= mid){
                count++;
                prev = arr[i];
            }
        }
        return count >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];
        while(high - low > 1){
            int mid = low + (high-low) / 2;
            if(function(position , m , mid)){
                low = mid;
            }
            else{
                high = mid - 1;
            }
        }
        if(function(position , m , high)){
            return high;
        }
        return low;
    }
}