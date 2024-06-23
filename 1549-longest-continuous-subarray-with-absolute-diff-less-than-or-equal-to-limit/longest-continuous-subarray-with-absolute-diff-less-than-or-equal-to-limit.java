class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> nums[b]-nums[a]);
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> nums[a]-nums[b]);

        int n = nums.length;
        int ans = 0;
        int l = 0;
        int r = 0;

        while(r<n){
            maxHeap.add(r);
            minHeap.add(r);
            
            while(!maxHeap.isEmpty() &&!minHeap.isEmpty() && nums[maxHeap.peek()] - nums[minHeap.peek()] > limit ){
                while(l >= minHeap.peek()){
                    minHeap.poll();
                }
                while(l >= maxHeap.peek()){
                    maxHeap.poll();
                }

                l++;
            }

            ans = Math.max(ans , r-l+1);
            r++;
        }
        return ans;
    }
}