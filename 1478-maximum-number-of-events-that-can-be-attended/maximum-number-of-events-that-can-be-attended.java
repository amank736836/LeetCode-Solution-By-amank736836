class Solution 
{
    public int maxEvents(int events[][])
    {
        int n = events.length;

        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int i=0;
        int day=0;
        int ans = 0;

        while(i<n || !q.isEmpty()){
            if(q.isEmpty()){
                day = events[i][0];
            }

            while(i<n && day == events[i][0]){
                q.add(events[i][1]);
                i++;
            }

            q.poll();
            ans++;
            day++;

            while(!q.isEmpty() && day > q.peek()){
                q.poll();
            }

        }

        return ans;
    }
}
