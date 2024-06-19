class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer,Integer> remainderCount = new HashMap<>();
        int pairCount = 0;
        for(int hour : hours){
            int remainder = hour % 24;
            int complement = (remainder == 0) ? 0 : 24 - remainder;
            if(remainderCount.containsKey(complement)){
                pairCount += remainderCount.get(complement);
            }
            remainderCount.put(remainder , remainderCount.getOrDefault(remainder , 0)+1);
        }
        return pairCount;
    }
}