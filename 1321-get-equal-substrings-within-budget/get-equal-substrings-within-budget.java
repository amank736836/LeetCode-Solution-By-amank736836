class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0;
        int r;
        for(r = 0; r < s.length(); r++){
            maxCost -= Math.abs(s.charAt(r) - t.charAt(r));
            if(maxCost < 0){
                maxCost += Math.abs(s.charAt(l) - t.charAt(l++));
            }
        }
        return r - l;
    }
}