class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int l = arr.length;
        if(l<2){
            return true;
        }

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<l;i++){
            hm.put(arr[i] , hm.getOrDefault(arr[i],0) + 1);
        }

        HashMap<Integer,Boolean> occurrenceMap = new HashMap<>();
        for(int value : hm.values()){
            if(occurrenceMap.containsKey(value)){
                return false;
            }
            occurrenceMap.put(value,true);
        }

        return true;

    }
}