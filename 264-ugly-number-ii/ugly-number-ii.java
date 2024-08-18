class Solution {
    public int nthUglyNumber(int n) {
        int primes[] = {2,3,5};
        PriorityQueue<Long> uglyHeap = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();
        uglyHeap.add(1L);
        visited.add(1L);
        long curr = 1L;
        for(int i=0;i<n;i++){
            curr = uglyHeap.poll();
            for(int prime : primes){
                long newUgly = curr * prime;
                if(!visited.contains(newUgly)){
                    uglyHeap.add(newUgly);
                    visited.add(newUgly);
                }
            }
        }
        return (int)curr;
    }
}