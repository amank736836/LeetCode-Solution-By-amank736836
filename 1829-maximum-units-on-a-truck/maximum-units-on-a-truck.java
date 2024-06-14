class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes , (a,b) -> b[1] - a[1]);
        int n = boxTypes.length;
        int i=0;
        int max = 0;
        while(truckSize > 0 && i < n){
            if(boxTypes[i][0] <= truckSize){
                max += boxTypes[i][1] * boxTypes[i][0];
                truckSize -= boxTypes[i][0];
            }else{
                max += boxTypes[i][1] * truckSize;
                truckSize -= truckSize;
                break;
            }
            i++;
        }
        return max;
    }
}