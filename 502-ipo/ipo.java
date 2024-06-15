class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> projects = new ArrayList<>();
        for(int i=0;i<n;i++){
            projects.add(new int[]{capital[i] , profits[i]});
        }
        projects.sort((a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
        int i=0;
        for(int j=0;j<k;j++){
            while(i<n && projects.get(i)[0] <= w){
                maxHeap.add(projects.get(i)[1]);
                i++;
            }
            if(maxHeap.isEmpty()){
                break;
            }
            w+= maxHeap.poll();
        }
        return w;
    }
}