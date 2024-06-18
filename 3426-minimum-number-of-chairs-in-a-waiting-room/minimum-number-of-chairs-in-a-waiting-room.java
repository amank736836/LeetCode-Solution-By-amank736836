class Solution {
    public int minimumChairs(String s) {
        int count = 0;
        int maxChairs= 0;
        for(char event : s.toCharArray()){
            if(event == 'E'){
                count++;
            }
            else if(event == 'L'){
                count--;
            }
            maxChairs = Math.max(maxChairs,count);
        }
        return maxChairs;
    }
}