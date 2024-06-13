class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        int m = colors.length();
        for(int i=0;i<m-1;i++){
            char x = colors.charAt(i);
            char y = colors.charAt(i+1);
            if(x==y){
                if(neededTime[i] <= neededTime[i+1]){
                    minCost += neededTime[i];
                }else{
                    minCost += neededTime[i+1];
                    neededTime[i+1] = neededTime[i];
                }
            }
        }

        return minCost;
    }
}