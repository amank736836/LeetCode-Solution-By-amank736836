class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        
        int arr[] = new int[num_people];
        int i=1;

        int j=0;
        while(candies > 0){
            if(j==num_people){
                j = 0;
            }
            if(i <= candies){
                arr[j] += i;
            }else{
                arr[j] += candies;
            }
            candies -= i;
            i++;
            j++;
        }

        return arr;

    }
}