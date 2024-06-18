class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ret = 0;
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int i=0;i<profit.length;i++){
            pq.offer(new int[]{profit[i],difficulty[i]});
        }
        Arrays.sort(worker);
        int workerIndex = worker.length - 1;

        while(!pq.isEmpty() && workerIndex >= 0){
            int[] top = pq.peek();
            while(!pq.isEmpty() && top[1] > worker[workerIndex]){
                pq.poll();
                if(!pq.isEmpty()){
                    top = pq.peek();
                }
            }
            if(!pq.isEmpty()){
                ret += top[0];
                workerIndex--;
            }
        }
        return ret;
    }
}