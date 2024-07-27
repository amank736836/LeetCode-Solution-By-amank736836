class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<int[]> adj[] = new ArrayList[26];
        long minCost = 0;
        HashMap<Pair<Character,Character>,Long> memo = new HashMap<>();

        for(int i=0;i<26;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<original.length;i++){
            adj[original[i] - 'a'].add(new int[]{changed[i] - 'a' , cost[i]});
        }

        for(int i=0;i<source.length();i++){
            Pair key = new Pair(source.charAt(i),target.charAt(i));
            if(memo.containsKey(key)){
                minCost += memo.get(key);
                continue;
            }

            boolean converted = false;
            boolean seen[] = new boolean[26];
            long charCost = 0;
            Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
            queue.offer(new int[]{source.charAt(i)-'a',0});

            while(!queue.isEmpty()){
                int a[] = queue.poll();
                int c = a[0];
                int costSoFar = a[1];

                if((char) (c + 'a') == target.charAt(i)){
                    charCost += costSoFar;
                    converted = true;
                    break;
                }
                if(seen[c]){
                    continue;
                }
                seen[c] = true;
                for(int neighbour[] : adj[c]){
                    if(!seen[neighbour[0]]){
                        queue.offer(new int[]{neighbour[0],costSoFar + neighbour[1]});
                    }
                }
            }

            if(!converted){
                return -1;
            }
            minCost += charCost;
            memo.put(key,charCost);

        }


        return minCost;
    }
}