class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(String item : arr){
            hm.put(item,hm.getOrDefault(item,0)+1);
        }
        for(String item : arr){
            if(hm.get(item) == 1){
                k--;
            }
            if(k==0){
                return item;
            }
        }
        return  "";
    }
}